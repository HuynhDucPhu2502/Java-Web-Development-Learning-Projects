export interface Department {
  id: string;
  name: string;
}

export interface Employee {
  id: string;
  name: string;
  salary: number;
  department: Department;
}
