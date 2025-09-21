import { useState } from "react";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { DepartmentForm } from "@/pages/components/department-form";
import { EmployeeForm } from "@/pages/components/employee-form";
import { DepartmentList } from "@/pages/components/department-list";
import { EmployeeList } from "@/pages/components/employee-list";
import { mockDepartments, mockEmployees } from "@/lib/mock-data";
import type { Department, Employee } from "@/types";

export default function HomePage() {
  const [departments, setDepartments] = useState<Department[]>(mockDepartments);
  const [employees, setEmployees] = useState<Employee[]>(mockEmployees);

  const handleAddDepartment = (newDepartment: Omit<Department, "id">) => {
    const department: Department = {
      ...newDepartment,
      id: (departments.length + 1).toString(),
    };
    setDepartments([...departments, department]);
  };

  const handleAddEmployee = (newEmployee: Omit<Employee, "id">) => {
    const employee: Employee = {
      ...newEmployee,
      id: (employees.length + 1).toString(),
    };
    setEmployees([...employees, employee]);
  };

  return (
    <div className="container mx-auto py-8 px-4">
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-center mb-2">
          Hệ Thống Quản Lý Nhân Viên
        </h1>
        <p className="text-muted-foreground text-center">
          Quản lý phòng ban và nhân viên một cách hiệu quả
        </p>
      </div>

      <Tabs defaultValue="employees" className="space-y-6">
        <TabsList className="grid w-full grid-cols-4">
          <TabsTrigger value="employees">Nhân Viên</TabsTrigger>
          <TabsTrigger value="departments">Phòng Ban</TabsTrigger>
          <TabsTrigger value="add-employee">Thêm NV</TabsTrigger>
          <TabsTrigger value="add-department">Thêm PB</TabsTrigger>
        </TabsList>

        <TabsContent value="employees" className="space-y-6">
          <EmployeeList employees={employees} />
        </TabsContent>

        <TabsContent value="departments" className="space-y-6">
          <DepartmentList departments={departments} employees={employees} />
        </TabsContent>

        <TabsContent value="add-employee" className="space-y-6">
          <div className="max-w-md mx-auto">
            <EmployeeForm
              departments={departments}
              onSubmit={handleAddEmployee}
            />
          </div>
        </TabsContent>

        <TabsContent value="add-department" className="space-y-6">
          <div className="max-w-md mx-auto">
            <DepartmentForm onSubmit={handleAddDepartment} />
          </div>
        </TabsContent>
      </Tabs>
    </div>
  );
}
