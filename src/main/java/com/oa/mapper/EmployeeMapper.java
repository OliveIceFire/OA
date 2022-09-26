package com.oa.mapper;

import com.oa.entity.Employee;

public interface EmployeeMapper {
    Employee selectById(Long employeeId);
}
