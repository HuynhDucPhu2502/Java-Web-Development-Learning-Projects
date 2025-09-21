"use client";

import type React from "react";
import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Plus } from "lucide-react";
import type { Department, Employee } from "@/types";

interface EmployeeFormProps {
  departments: Department[];
  onSubmit: (employee: Omit<Employee, "id">) => void;
}

export function EmployeeForm({ departments, onSubmit }: EmployeeFormProps) {
  const [name, setName] = useState("");
  const [salary, setSalary] = useState("");
  const [departmentId, setDepartmentId] = useState("");
  const [open, setOpen] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    const selectedDepartment = departments.find((d) => d.id === departmentId);

    if (name.trim() && salary && selectedDepartment) {
      onSubmit({
        name: name.trim(),
        salary: Number.parseFloat(salary),
        department: selectedDepartment,
      });
      setName("");
      setSalary("");
      setDepartmentId("");
      setOpen(false);
    }
  };

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>
        <Button>
          <Plus className="h-4 w-4 mr-2" />
          Thêm Nhân Viên
        </Button>
      </DialogTrigger>
      <DialogContent className="sm:max-w-md">
        <DialogHeader>
          <DialogTitle>Thêm Nhân Viên Mới</DialogTitle>
        </DialogHeader>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <Label htmlFor="employee-name">Tên Nhân Viên</Label>
            <Input
              id="employee-name"
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Nhập tên nhân viên..."
              required
            />
          </div>

          <div>
            <Label htmlFor="employee-salary">Lương (VNĐ)</Label>
            <Input
              id="employee-salary"
              type="number"
              value={salary}
              onChange={(e) => setSalary(e.target.value)}
              placeholder="Nhập lương..."
              min="0"
              step="1000"
              required
            />
          </div>

          <div>
            <Label htmlFor="employee-department">Phòng Ban</Label>
            <Select
              value={departmentId}
              onValueChange={setDepartmentId}
              required
            >
              <SelectTrigger>
                <SelectValue placeholder="Chọn phòng ban..." />
              </SelectTrigger>
              <SelectContent>
                {departments?.map((dept) => (
                  <SelectItem key={dept.id} value={dept.id}>
                    {dept.name}
                  </SelectItem>
                )) || []}
              </SelectContent>
            </Select>
          </div>

          <Button type="submit" className="w-full">
            Thêm Nhân Viên
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
