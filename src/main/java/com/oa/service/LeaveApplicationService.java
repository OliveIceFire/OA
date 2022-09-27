package com.oa.service;

import com.oa.entity.Employee;
import com.oa.entity.LeaveApplication;
import com.oa.entity.ProcessFlow;
import com.oa.mapper.EmployeeMapper;
import com.oa.mapper.LeaveApplicationMapper;
import com.oa.mapper.ProcessFlowMapper;
import com.oa.utils.MybatisUtils;

import java.util.Date;

public class LeaveApplicationService {
    private EmployeeService employeeService = new EmployeeService();

    public LeaveApplication createLeaveApplication(LeaveApplication leaveApplication) {
        LeaveApplication leaveApplicationForReturn = (LeaveApplication) MybatisUtils.executeUpdate(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(leaveApplication.getEmployeeId());
            if (employee.getLevel() == 8) {
                leaveApplication.setState("approved");
            } else {
                leaveApplication.setState("processing");
            }
            LeaveApplicationMapper leaveApplicationMapper = sqlSession.getMapper(LeaveApplicationMapper.class);
            leaveApplicationMapper.insert(leaveApplication);
            //增加第一条表单数据,说明表单已经提交
            ProcessFlowMapper processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);
            ProcessFlow flow1 = new ProcessFlow();
            flow1.setFormId(leaveApplication.getFormId());
            flow1.setOperatorId(employee.getEmployeeId());
            flow1.setAction("apply");
            flow1.setCreateTime(new Date());
            flow1.setOrderNo(1);
            flow1.setState("complete");
            flow1.setIsLast(0);
            processFlowMapper.insert(flow1);
//            7级以下的员工,生成部门经理审批任务,请假时间大于等于72小时,还需生成总经理审批任务
//            7级员工,仅生成总经理审批任务
//            8级员工,生成总经理审批任务,系统自动通过

            if (employee.getLevel() < 7) {
                //部门 经理审批
                Employee departmentManager = employeeService.selectLeaderById(employee.getEmployeeId());
                ProcessFlow flow2 = new ProcessFlow();
                flow2.setFormId(leaveApplication.getFormId());
                flow2.setOperatorId(departmentManager.getEmployeeId());
                flow2.setAction("audit");
                flow2.setCreateTime(new Date());
                flow2.setState("process");
                long diff = leaveApplication.getEndTime().getTime() - leaveApplication.getStartTime().getTime();
                float hours = diff / (1000 * 60 * 60) * 1f;
                if (hours >= 72) {
                    flow2.setIsLast(0);
                    processFlowMapper.insert(flow2);
                    //总经理开始审批
                    Employee generalManager = employeeService.selectLeaderById(departmentManager.getEmployeeId());
                    ProcessFlow flow3 = new ProcessFlow();
                    flow3.setFormId(leaveApplication.getFormId());
                    flow3.setOperatorId(generalManager.getEmployeeId());
                    flow3.setAction("audit");
                    flow3.setCreateTime(new Date());
                    flow3.setState("ready");
                    flow3.setOrderNo(3);
                    flow3.setIsLast(1);
                    processFlowMapper.insert(flow3);
                } else {
                    flow2.setIsLast(1);
                    processFlowMapper.insert(flow2);
                }
            } else if (employee.getLevel() == 7) {
                Employee generalManager = employeeService.selectLeaderById(employee.getEmployeeId());
                ProcessFlow flow2 = new ProcessFlow();
                flow2.setFormId(leaveApplication.getFormId());
                flow2.setOperatorId(generalManager.getEmployeeId());
                flow2.setAction("audit");
                flow2.setCreateTime(new Date());
                flow2.setState("process");
                flow2.setOrderNo(2);
                flow2.setIsLast(1);
                processFlowMapper.insert(flow2);
            } else if (employee.getLevel() == 8) {
                //总经理审批,系统自动通过
                ProcessFlow flow2 = new ProcessFlow();
                flow2.setFormId(leaveApplication.getFormId());
                flow2.setOperatorId(employee.getEmployeeId());
                flow2.setAction("audit");
                flow2.setResult("approved");
                flow2.setReason("自动通过");
                flow2.setCreateTime(new Date());
                flow2.setAuditTime(new Date());
                flow2.setState("complete");
                flow2.setOrderNo(2);
                flow2.setIsLast(1);
                processFlowMapper.insert(flow2);
            }
            return leaveApplication;
        });
        return leaveApplicationForReturn;
    }
}
