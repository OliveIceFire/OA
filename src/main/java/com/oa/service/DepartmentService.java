package com.oa.service;

import com.oa.entity.Department;
import com.oa.entity.Employee;
import com.oa.mapper.DepartmentMapper;
import com.oa.mapper.EmployeeMapper;
import com.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentService {
    public Department selectById(Long departmentId) {
        Department department = (Department) MybatisUtils.executeQuery(sqlSession -> {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            return mapper.selectById(departmentId);
        });
        return department;
    }

}
