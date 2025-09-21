import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import type { Department, Employee } from "@/types";

interface DepartmentListProps {
  departments: Department[];
  employees: Employee[];
}

export function DepartmentList({
  departments,
  employees,
}: DepartmentListProps) {
  const getEmployeeCount = (departmentId: string) => {
    return employees.filter((emp) => emp.department.id === departmentId).length;
  };

  return (
    <Card>
      <CardHeader>
        <CardTitle>Danh Sách Phòng Ban</CardTitle>
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
              <Badge variant="secondary">
                {getEmployeeCount(department.id)} nhân viên
              </Badge>
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
}
