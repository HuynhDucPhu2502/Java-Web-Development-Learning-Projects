export interface DepartmentResponse {
  id: string;
  name: string;
}

export interface EmployeeResponse {
  id: string;
  name: string;
  salary: number;
  departmentName: string;
  departmentId: string;
}

export interface DepartmentRequest {
  name: string;
}

export interface EmployeeRequest {
  name: string;
  salary: number;
  departmentId: string;
}
