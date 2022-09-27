package com.oa.controller;

import com.oa.entity.LeaveApplication;
import com.oa.service.LeaveApplicationService;
import com.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/api/leave/*")
public class LeaveApplicationServlet extends HttpServlet {

    private LeaveApplicationService leaveApplicationService = new LeaveApplicationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");

        String uri = req.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        if (methodName.equals("create")) {
            this.create(req, resp);
        } else if (methodName.equals("list")) {

        } else if (methodName.equals("audit")) {

        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strEmployeeId = req.getParameter("eid");
        String formType = req.getParameter("formType");
        //从1970年到现在的毫秒数
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String reason = req.getParameter("reason");
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setEmployeeId(Long.parseLong(strEmployeeId));
        leaveApplication.setStartTime(new Date(Long.parseLong(startTime)));
        leaveApplication.setEndTime(new Date(Long.parseLong(endTime)));
        leaveApplication.setFormType(Integer.parseInt(formType));
        leaveApplication.setReason(reason);
        leaveApplication.setCreateTime(new Date());
        ResponseUtils responseUtils = null;
        try {
            leaveApplicationService.createLeaveApplication(leaveApplication);
            responseUtils = new ResponseUtils();
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        resp.getWriter().println(responseUtils.toJsonString());
    }


}
