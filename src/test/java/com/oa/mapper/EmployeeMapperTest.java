package com.oa.mapper;

import com.oa.entity.Employee;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

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
}