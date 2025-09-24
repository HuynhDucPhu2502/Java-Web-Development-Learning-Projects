"use client";

import { useState } from "react";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog";
import { Edit, Trash2 } from "lucide-react";
import { DepartmentForm } from "./department-form";
import type {
  DepartmentResponse,
  EmployeeResponse,
  DepartmentRequest,
} from "@/types";

interface DepartmentListProps {
  departments: DepartmentResponse[];
  employees: EmployeeResponse[];
  onAddDepartment: (department: DepartmentRequest) => void;
  onEditDepartment?: (
    departmentId: string,
    department: DepartmentRequest
  ) => void;
  onDeleteDepartment?: (departmentId: string) => void;
}

export function DepartmentList({
  departments,
  employees,
  onAddDepartment,
  onEditDepartment,
  onDeleteDepartment,
}: DepartmentListProps) {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);
  const [selectedDepartment, setSelectedDepartment] =
    useState<DepartmentResponse | null>(null);

  const getEmployeeCount = (departmentId: string) => {
    return employees.filter((emp) => emp.departmentId === departmentId).length;
  };

  const handleEdit = (department: DepartmentResponse) => {
    setSelectedDepartment(department);
    setIsEditModalOpen(true);
  };

  const handleDelete = (department: DepartmentResponse) => {
    if (onDeleteDepartment) {
      onDeleteDepartment(department.id);
    }
  };

  const handleEditSubmit = (
    departmentId: string,
    updatedDepartment: DepartmentRequest
  ) => {
    if (onEditDepartment) {
      onEditDepartment(departmentId, updatedDepartment);
    }
    setIsEditModalOpen(false);
    setSelectedDepartment(null);
  };

  return (
    <>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle>Danh Sách Phòng Ban</CardTitle>
          <Button onClick={() => setIsModalOpen(true)}>Thêm Phòng Ban</Button>
        </CardHeader>
        <CardContent>
          <div className="space-y-3">
            {departments.map((department) => (
              <div
                key={department.id}
                className="flex items-center justify-between p-3 border rounded-lg"
              >
                <div>
                  <h3 className="font-medium">{department.name}</h3>
                  <p className="text-sm text-muted-foreground">
                    ID: {department.id}
                  </p>
                </div>
                <div className="flex items-center gap-3">
                  <Badge variant="secondary">
                    {getEmployeeCount(department.id)} nhân viên
                  </Badge>
                  <div className="flex gap-2">
                    <Button
                      variant="outline"
                      size="sm"
                      onClick={() => handleEdit(department)}
                    >
                      <Edit className="h-4 w-4" />
                    </Button>
                    <AlertDialog>
                      <AlertDialogTrigger asChild>
                        <Button variant="outline" size="sm">
                          <Trash2 className="h-4 w-4" />
                        </Button>
                      </AlertDialogTrigger>
                      <AlertDialogContent>
                        <AlertDialogHeader>
                          <AlertDialogTitle>
                            Xác nhận xóa phòng ban
                          </AlertDialogTitle>
                          <AlertDialogDescription>
                            Bạn có chắc chắn muốn xóa phòng ban "
                            {department.name}"? Phòng ban này hiện có{" "}
                            {getEmployeeCount(department.id)} nhân viên. Hành
                            động này không thể hoàn tác.
                          </AlertDialogDescription>
                        </AlertDialogHeader>
                        <AlertDialogFooter>
                          <AlertDialogCancel>Hủy</AlertDialogCancel>
                          <AlertDialogAction
                            onClick={() => handleDelete(department)}
                            className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
                          >
                            Xóa
                          </AlertDialogAction>
                        </AlertDialogFooter>
                      </AlertDialogContent>
                    </AlertDialog>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </CardContent>
      </Card>

      <DepartmentForm
        onSubmit={onAddDepartment}
        open={isModalOpen}
        onOpenChange={setIsModalOpen}
      />

      <DepartmentForm
        onSubmit={onAddDepartment}
        open={isEditModalOpen}
        onOpenChange={setIsEditModalOpen}
        editDepartment={selectedDepartment}
        onEdit={handleEditSubmit}
      />
    </>
  );
}
