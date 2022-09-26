package com.oa.service;

import com.oa.entity.Employee;
import com.oa.mapper.EmployeeMapper;
import com.oa.utils.MybatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId) {
        Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
        return employee;
    }
}
