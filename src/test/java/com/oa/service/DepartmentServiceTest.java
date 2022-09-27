package com.oa.service;

import com.oa.entity.Department;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

public class DepartmentServiceTest extends TestCase {

    private DepartmentService departmentService = new DepartmentService();

    @Test
    public void testSelectById() {
        MybatisUtils.executeQuery(sqlSession -> {
            Department department = departmentService.selectById(1L);
            System.out.println(department);
            return department;
        });
    }
}