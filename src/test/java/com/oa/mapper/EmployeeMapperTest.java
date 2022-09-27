package com.oa.mapper;

import com.oa.entity.Employee;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMapperTest extends TestCase {

    @Test
    public void testSelectById() {
        Employee emp = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            //自动生成实现类
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(4L);
            System.out.println(employee);
            return employee;
        });
    }

    @Test
    public void testSelectByParams1() {
        Map params = new HashMap<>();
        params.put("level", 7);
        params.put("departmentId", 2);
        MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectByParams(params);
            System.out.println(employees);
            return employees;
        });
    }

    @Test
    public void testSelectByParams2() {
        Map params = new HashMap<>();
        params.put("level", 8);
        MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectByParams(params);
            System.out.println(employees);
            return employees;
        });
    }
}