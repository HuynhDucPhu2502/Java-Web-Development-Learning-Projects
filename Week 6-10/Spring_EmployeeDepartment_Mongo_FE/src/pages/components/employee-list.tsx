"use client";

import { useState } from "react";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
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
import { EmployeeForm } from "./employee-form";
import type {
  EmployeeResponse,
  DepartmentResponse,
  EmployeeRequest,
} from "@/types";

interface EmployeeListProps {
  employees: EmployeeResponse[];
  departments: DepartmentResponse[];
  onAddEmployee: (employee: EmployeeRequest) => void;
  onEditEmployee: (id: string, employee: EmployeeRequest) => void;
  onDeleteEmployee: (id: string) => void;
}

export function EmployeeList({
  employees,
  departments,
  onAddEmployee,
  onEditEmployee,
  onDeleteEmployee,
}: EmployeeListProps) {
  const [editingEmployee, setEditingEmployee] =
    useState<EmployeeResponse | null>(null);
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);

  const formatSalary = (salary: number) => {
    return salary.toLocaleString("vi-VN") + " đ";
  };

  const handleEdit = (employee: EmployeeResponse) => {
    setEditingEmployee(employee);
    setIsEditModalOpen(true);
  };

  const handleUpdate = (id: string, employee: EmployeeRequest) => {
    onEditEmployee(id, employee);
    setEditingEmployee(null);
    setIsEditModalOpen(false);
  };

  const handleDelete = (employee: EmployeeResponse) => {
    onDeleteEmployee(employee.id);
  };

  return (
    <Card>
      <CardHeader>
        <div className="flex items-center justify-between">
          <CardTitle>Danh Sách Nhân Viên</CardTitle>
          <EmployeeForm departments={departments} onSubmit={onAddEmployee} />
        </div>
      </CardHeader>
      <CardContent>
        <div className="rounded-md border">
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead className="w-16">ID</TableHead>
                <TableHead>Tên Nhân Viên</TableHead>
                <TableHead>Lương</TableHead>
                <TableHead>Phòng Ban</TableHead>
                <TableHead className="w-32">Thao Tác</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {employees.map((employee) => (
                <TableRow key={employee.id}>
                  <TableCell className="font-mono text-sm text-muted-foreground">
                    {employee.id}
                  </TableCell>
                  <TableCell className="font-medium">{employee.name}</TableCell>
                  <TableCell className="font-medium text-green-600">
                    {formatSalary(employee.salary)}
                  </TableCell>
                  <TableCell>
                    <Badge variant="outline">{employee.departmentName}</Badge>
                  </TableCell>
                  <TableCell>
                    <div className="flex gap-2">
                      <Button
                        variant="outline"
                        size="sm"
                        onClick={() => handleEdit(employee)}
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
                              Xác nhận xóa nhân viên
                            </AlertDialogTitle>
                            <AlertDialogDescription>
                              Bạn có chắc chắn muốn xóa nhân viên "
                              {employee.name}"? Hành động này không thể hoàn
                              tác.
                            </AlertDialogDescription>
                          </AlertDialogHeader>
                          <AlertDialogFooter>
                            <AlertDialogCancel>Hủy</AlertDialogCancel>
                            <AlertDialogAction
                              onClick={() => handleDelete(employee)}
                              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
                            >
                              Xóa
                            </AlertDialogAction>
                          </AlertDialogFooter>
                        </AlertDialogContent>
                      </AlertDialog>
                    </div>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </CardContent>

      {isEditModalOpen && (
        <EmployeeForm
          departments={departments}
          onSubmit={onAddEmployee}
          editEmployee={editingEmployee}
          onUpdate={handleUpdate}
          isOpen={isEditModalOpen}
          onOpenChange={setIsEditModalOpen}
        />
      )}
    </Card>
  );
}
