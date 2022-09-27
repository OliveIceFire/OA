package com.oa.service;

import com.oa.entity.LeaveApplication;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveApplicationServiceTest extends TestCase {
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();

    @Test
    public void createLeaveForm1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setEmployeeId(8L);
        leaveApplication.setStartTime(sdf.parse("2020032608"));
        leaveApplication.setEndTime(sdf.parse("2020040118"));
        leaveApplication.setFormType(1);
        leaveApplication.setReason("市场部员工请假单(72小时以上)");
        leaveApplication.setCreateTime(new Date());
        LeaveApplication savedForm = leaveApplicationService.createLeaveApplication(leaveApplication);
        System.out.println(savedForm.getFormId());
    }

    /**
     * 市场部员工请假单(72小时内)测试用例
     *
     * @throws ParseException
     */
    @Test
    public void createLeaveForm2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setEmployeeId(8L);
        leaveApplication.setStartTime(sdf.parse("2020032608"));
        leaveApplication.setEndTime(sdf.parse("2020032718"));
        leaveApplication.setFormType(1);
        leaveApplication.setReason("市场部员工请假单(72小时内)");
        leaveApplication.setCreateTime(new Date());
        LeaveApplication savedForm = leaveApplicationService.createLeaveApplication(leaveApplication);
        System.out.println(savedForm.getFormId());
    }

    /**
     * 研发部部门经理请假单测试用例
     *
     * @throws ParseException
     */
    @Test
    public void createLeaveForm3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setEmployeeId(2L);
        leaveApplication.setStartTime(sdf.parse("2020032608"));
        leaveApplication.setEndTime(sdf.parse("2020040118"));
        leaveApplication.setFormType(1);
        leaveApplication.setReason("研发部部门经理请假单");
        leaveApplication.setCreateTime(new Date());
        LeaveApplication savedForm = leaveApplicationService.createLeaveApplication(leaveApplication);
        System.out.println(savedForm.getFormId());
    }

    /**
     * 总经理请假单测试用例
     *
     * @throws ParseException
     */
    @Test
    public void createLeaveForm4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setEmployeeId(1L);
        leaveApplication.setStartTime(sdf.parse("2020032608"));
        leaveApplication.setEndTime(sdf.parse("2020040118"));
        leaveApplication.setFormType(1);
        leaveApplication.setReason("总经理请假单");
        leaveApplication.setCreateTime(new Date());
        LeaveApplication savedForm = leaveApplicationService.createLeaveApplication(leaveApplication);
        System.out.println(savedForm.getFormId());
    }
}