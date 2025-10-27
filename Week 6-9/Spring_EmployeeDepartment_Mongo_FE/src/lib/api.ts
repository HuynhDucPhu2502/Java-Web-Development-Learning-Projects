import type {
  EmployeeRequest,
  EmployeeResponse,
  DepartmentRequest,
  DepartmentResponse,
} from "@/types";
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    "Content-Type": "application/json",
  },
});

//
// 🚀 Employee API
//
export async function getEmployees(): Promise<EmployeeResponse[]> {
  const res = await api.get<EmployeeResponse[]>("/employees");
  return res.data;
}

export async function createEmployee(
  data: EmployeeRequest
): Promise<EmployeeResponse> {
  const res = await api.post<EmployeeResponse>("/employees", data);
  return res.data;
}

export async function updateEmployee(
  id: string,
  data: EmployeeRequest
): Promise<EmployeeResponse> {
  const res = await api.put<EmployeeResponse>(`/employees/${id}`, data);
  return res.data;
}

export async function deleteEmployee(id: string): Promise<void> {
  await api.delete(`/employees/${id}`);
}

//
// 🚀 Department API
//
export async function getDepartments(): Promise<DepartmentResponse[]> {
  const res = await api.get<DepartmentResponse[]>("/departments");
  return res.data;
}

export async function createDepartment(
  data: DepartmentRequest
): Promise<DepartmentResponse> {
  const res = await api.post<DepartmentResponse>("/departments", data);
  return res.data;
}

export async function updateDepartment(
  id: string,
  data: DepartmentRequest
): Promise<DepartmentResponse> {
  const res = await api.put<DepartmentResponse>(`/departments/${id}`, data);
  return res.data;
}

export async function deleteDepartment(id: string): Promise<void> {
  await api.delete(`/departments/${id}`);
}
