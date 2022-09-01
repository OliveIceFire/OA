package com.oa.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oa.entity.User;
import com.oa.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    //doGet doPost 即使有相同逻辑, 也不能使用super继承

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");

        String password = request.getParameter("password");
        Map result = new LinkedHashMap<>();
        try {
            User user = userService.checkLogin(username, password);
            result.put("code", "0");
            result.put("message", "success");
            Map data = new LinkedHashMap<>();
            data.put("user", user);
            result.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");

        String password = request.getParameter("password");
        Map result = new LinkedHashMap<>();
        try {
            User user = userService.checkLogin(username, password);
            result.put("code", "0");
            result.put("message", "success");
            Map data = new LinkedHashMap<>();
            data.put("user", user);
            result.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().println(json);

    }
}
