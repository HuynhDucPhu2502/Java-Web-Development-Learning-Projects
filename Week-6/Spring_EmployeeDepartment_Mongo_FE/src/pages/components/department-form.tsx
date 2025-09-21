import type React from "react";

import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import type { Department } from "@/types";

interface DepartmentFormProps {
  onSubmit: (department: Omit<Department, "id">) => void;
}

export function DepartmentForm({ onSubmit }: DepartmentFormProps) {
  const [name, setName] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (name.trim()) {
      onSubmit({ name: name.trim() });
      setName("");
    }
  };

  return (
    <Card>
      <CardHeader>
        <CardTitle>Thêm Phòng Ban Mới</CardTitle>
      </CardHeader>
      <CardContent>
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
            Thêm Phòng Ban
          </Button>
        </form>
      </CardContent>
    </Card>
  );
}
