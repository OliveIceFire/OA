package com.oa.controller;

import com.oa.entity.User;
import com.oa.service.UserService;
import com.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    //user example     :    username: m8 , password: test
    private final UserService userService = new UserService();
    //doGet doPost 即使有相同逻辑, 也不能使用super继承

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");

        String password = request.getParameter("password");
//        Map result = new LinkedHashMap<>();
        ResponseUtils responseUtils;
        try {
            User user = userService.checkLogin(username, password);
            user.setPassword(null);
            user.setSalt(null);
            responseUtils = new ResponseUtils().put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        String json = objectMapper.writeValueAsString(result);
        response.getWriter().println(responseUtils.toJsonString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");

        String password = request.getParameter("password");
//        Map result = new LinkedHashMap<>();
        ResponseUtils responseUtils;
        try {
            User user = userService.checkLogin(username, password);
            user.setPassword(null);
            user.setSalt(null);
            responseUtils = new ResponseUtils().put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        String json = objectMapper.writeValueAsString(result);
        response.getWriter().println(responseUtils.toJsonString());

    }
}
