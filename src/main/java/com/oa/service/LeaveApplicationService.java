package com.oa.service;

import com.oa.entity.LeaveApplication;
import com.oa.mapper.EmployeeMapper;
import com.oa.utils.MybatisUtils;

public class LeaveApplicationService {
    private EmployeeService employeeService = new EmployeeService();

    public LeaveApplication createLeaveApplication() {
        MybatisUtils.executeUpdate(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            return null;
        });
        return null;
    }
}
