package com.oa.service;

import com.oa.entity.Employee;
import com.oa.mapper.EmployeeMapper;
import com.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    public Employee selectById(Long employeeId) {
        Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
        return employee;
    }

    public Employee selectLeaderById(Long employeeId) {
        Employee employeeObject = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            Map params = new HashMap<>();
            Employee leader = null;
            if (employee.getLevel() < 7) {
                //查询部门经理
                params.put("level", 7);
                params.put("departmentId", employee.getDepartmentId());
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 7) {
                //查询总经理
                params.put("level", 8);
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 8) {
                //返回自己
                leader = employee;
            }
            return leader;
        });
        return employeeObject;
    }

}
