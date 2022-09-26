package com.oa.mapper;

import com.oa.entity.Employee;

public interface EmployeeMapper {
    public Employee selectById(Long employeeId);
}
