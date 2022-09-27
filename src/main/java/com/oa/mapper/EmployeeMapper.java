package com.oa.mapper;

import com.oa.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee selectById(Long employeeId);

    List<Employee> selectByParams(Map params);

}
