"use client";

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
import { Edit, Trash2 } from "lucide-react";
import { EmployeeForm } from "./employee-form";
import type { Employee, Department } from "@/types";

interface EmployeeListProps {
  employees: Employee[];
  departments: Department[];
  onAddEmployee: (employee: Omit<Employee, "id">) => void;
}

export function EmployeeList({
  employees,
  departments,
  onAddEmployee,
}: EmployeeListProps) {
  const formatSalary = (salary: number) => {
    return salary.toLocaleString("vi-VN") + " đ";
  };

  const handleEdit = (employee: Employee) => {
    // TODO: Implement edit logic
    console.log("Edit employee:", employee);
  };

  const handleDelete = (employee: Employee) => {
    // TODO: Implement delete logic
    console.log("Delete employee:", employee);
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
                    <Badge variant="outline">{employee.department.name}</Badge>
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
                      <Button
                        variant="outline"
                        size="sm"
                        onClick={() => handleDelete(employee)}
                      >
                        <Trash2 className="h-4 w-4" />
                      </Button>
                    </div>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </CardContent>
    </Card>
  );
}
