import type { Department, Employee } from "@/types";

export const mockDepartments: Department[] = [
  { id: "1", name: "Phòng Nhân sự" },
  { id: "2", name: "Phòng Kỹ thuật" },
  { id: "3", name: "Phòng Marketing" },
  { id: "4", name: "Phòng Tài chính" },
  { id: "5", name: "Phòng Kinh doanh" },
];

export const mockEmployees: Employee[] = [
  {
    id: "1",
    name: "Nguyễn Văn An",
    salary: 15000000,
    department: mockDepartments[0],
  },
  {
    id: "2",
    name: "Trần Thị Bình",
    salary: 25000000,
    department: mockDepartments[1],
  },
  {
    id: "3",
    name: "Lê Văn Cường",
    salary: 18000000,
    department: mockDepartments[2],
  },
  {
    id: "4",
    name: "Phạm Thị Dung",
    salary: 22000000,
    department: mockDepartments[3],
  },
  {
    id: "5",
    name: "Hoàng Văn Em",
    salary: 20000000,
    department: mockDepartments[1],
  },
  {
    id: "6",
    name: "Vũ Thị Phương",
    salary: 16000000,
    department: mockDepartments[4],
  },
];
