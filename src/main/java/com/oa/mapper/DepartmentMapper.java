package com.oa.mapper;

import com.oa.entity.Department;

public interface DepartmentMapper {
    Department selectById(Long departmentId);
}
