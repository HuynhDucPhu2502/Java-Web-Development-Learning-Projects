"use client";

import { useState, useEffect } from "react";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";

import type {
  DepartmentResponse,
  EmployeeResponse,
  DepartmentRequest,
  EmployeeRequest,
} from "@/types";
import {
  getDepartments,
  getEmployees,
  createDepartment,
  updateDepartment,
  deleteDepartment,
  createEmployee,
  updateEmployee,
  deleteEmployee,
} from "@/lib/api";
import { LoadingSpinner } from "@/components/custom/loading-spinner";
import { DepartmentList } from "./components/department-list";
import { EmployeeList } from "./components/employee-list";

export default function HomePage() {
  const [departments, setDepartments] = useState<DepartmentResponse[]>([]);
  const [employees, setEmployees] = useState<EmployeeResponse[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [isOperationLoading, setIsOperationLoading] = useState(false);

  const refreshData = async () => {
    try {
      const [departmentsData, employeesData] = await Promise.all([
        getDepartments(),
        getEmployees(),
      ]);
      setDepartments(departmentsData);
      setEmployees(employeesData);
    } catch (error) {
      console.error("Error refreshing data:", error);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    refreshData();
  }, []);

  const handleAddDepartment = async (newDepartment: DepartmentRequest) => {
    setIsOperationLoading(true);
    try {
      await createDepartment(newDepartment);
      await refreshData();
    } catch (error) {
      console.error("Error adding department:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  const handleEditDepartment = async (
    departmentId: string,
    updatedDepartment: DepartmentRequest
  ) => {
    setIsOperationLoading(true);
    try {
      await updateDepartment(departmentId, updatedDepartment);
      await refreshData();
    } catch (error) {
      console.error("Error updating department:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  const handleDeleteDepartment = async (departmentId: string) => {
    setIsOperationLoading(true);
    try {
      await deleteDepartment(departmentId);
      await refreshData();
    } catch (error) {
      console.error("Error deleting department:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  const handleAddEmployee = async (newEmployee: EmployeeRequest) => {
    setIsOperationLoading(true);
    try {
      await createEmployee(newEmployee);
      await refreshData();
    } catch (error) {
      console.error("Error adding employee:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  const handleEditEmployee = async (
    employeeId: string,
    updatedEmployee: EmployeeRequest
  ) => {
    setIsOperationLoading(true);
    try {
      await updateEmployee(employeeId, updatedEmployee);
      await refreshData();
    } catch (error) {
      console.error("Error updating employee:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  const handleDeleteEmployee = async (employeeId: string) => {
    setIsOperationLoading(true);
    try {
      await deleteEmployee(employeeId);
      await refreshData();
    } catch (error) {
      console.error("Error deleting employee:", error);
    } finally {
      setIsOperationLoading(false);
    }
  };

  if (isLoading) {
    return (
      <div className="min-h-screen gradient-bg">
        <div className="enhanced-container section-spacing">
          <div className="page-header text-center">
            <h1 className="text-4xl font-bold text-gradient mb-4">
              Hệ Thống Quản Lý Nhân Viên
            </h1>
            <p className="text-muted-foreground text-lg">
              Quản lý phòng ban và nhân viên một cách hiệu quả
            </p>
          </div>
          <div className="flex justify-center py-16">
            <div className="glass-card p-8 rounded-2xl">
              <LoadingSpinner size="lg" text="Đang tải dữ liệu..." />
            </div>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen gradient-bg">
      <div className="enhanced-container section-spacing">
        <div className="page-header text-center">
          <h1 className="text-4xl font-bold text-gradient mb-4">
            Hệ Thống Quản Lý Nhân Viên
          </h1>
          <p className="text-muted-foreground text-lg">
            Quản lý phòng ban và nhân viên một cách hiệu quả
          </p>
          <div className="divider-soft"></div>
        </div>

        {isOperationLoading && (
          <div className="fixed inset-0 bg-black/30 backdrop-blur-sm flex items-center justify-center z-50">
            <div className="glass-card p-8 rounded-2xl shadow-2xl">
              <LoadingSpinner size="md" text="Đang xử lý..." />
            </div>
          </div>
        )}

        <div className="glass-card p-6 rounded-2xl transition-all duration-200 hover:shadow-xl">
          <Tabs defaultValue="employees" className="space-y-8">
            <TabsList className="grid w-full grid-cols-2 h-12 p-1 bg-muted/50">
              <TabsTrigger value="employees" className="text-sm font-medium">
                👥 Nhân Viên
              </TabsTrigger>
              <TabsTrigger value="departments" className="text-sm font-medium">
                🏢 Phòng Ban
              </TabsTrigger>
            </TabsList>

            <TabsContent value="employees" className="space-y-6 mt-8">
              <EmployeeList
                employees={employees}
                departments={departments}
                onAddEmployee={handleAddEmployee}
                onEditEmployee={handleEditEmployee}
                onDeleteEmployee={handleDeleteEmployee}
              />
            </TabsContent>

            <TabsContent value="departments" className="space-y-6 mt-8">
              <DepartmentList
                departments={departments}
                employees={employees}
                onAddDepartment={handleAddDepartment}
                onEditDepartment={handleEditDepartment}
                onDeleteDepartment={handleDeleteDepartment}
              />
            </TabsContent>
          </Tabs>
        </div>
      </div>
    </div>
  );
}
