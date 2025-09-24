"use client";

import type React from "react";
import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog";
import type { DepartmentRequest, DepartmentResponse } from "@/types";

interface DepartmentFormProps {
  onSubmit: (department: DepartmentRequest) => void;
  open: boolean;
  onOpenChange: (open: boolean) => void;
  editDepartment?: DepartmentResponse | null;
  onEdit?: (departmentId: string, department: DepartmentRequest) => void;
}

export function DepartmentForm({
  onSubmit,
  open,
  onOpenChange,
  editDepartment,
  onEdit,
}: DepartmentFormProps) {
  const [name, setName] = useState("");

  useEffect(() => {
    if (editDepartment) {
      setName(editDepartment.name);
    } else {
      setName("");
    }
  }, [editDepartment]);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (name.trim()) {
      if (editDepartment && onEdit) {
        onEdit(editDepartment.id, { name: name.trim() });
      } else {
        onSubmit({ name: name.trim() });
      }
      setName("");
      onOpenChange(false);
    }
  };

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>
            {editDepartment ? "Chỉnh Sửa Phòng Ban" : "Thêm Phòng Ban Mới"}
          </DialogTitle>
        </DialogHeader>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <Label htmlFor="department-name">Tên Phòng Ban</Label>
            <Input
              id="department-name"
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Nhập tên phòng ban..."
              required
            />
          </div>
          <Button type="submit" className="w-full">
            {editDepartment ? "Cập Nhật Phòng Ban" : "Thêm Phòng Ban"}
          </Button>
        </form>
      </DialogContent>
    </Dialog>
  );
}
