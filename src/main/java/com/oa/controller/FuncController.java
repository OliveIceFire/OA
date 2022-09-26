package com.oa.controller;

import com.oa.entity.Employee;
import com.oa.entity.Node;
import com.oa.service.EmployeeService;
import com.oa.service.FuncService;
import com.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/user_info")
public class FuncController extends HttpServlet {
    private FuncService funcService = new FuncService();//初始化
    private EmployeeService employeeService = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("running now");
        String uid = req.getParameter("uid");
        String eid = req.getParameter("eid");
        List<Node> nodes = funcService.selectNodeByUserId(Long.valueOf(uid));
        List<Map> treeList = new ArrayList<>();
//        System.out.println("running now");
        Map module = null;
        for (Node node : nodes) {
            if (node.getNodeType() == 1) {
                module = new LinkedHashMap();
                module.put("node", node);
                module.put("children", new ArrayList<>());
                treeList.add(module);
            } else if (node.getNodeType() == 2) {
                List children = (List) module.get("children");
                children.add(node);
            }
        }
        System.out.println("running now");
//        String jsonString = new ResponseUtils().put("nodeList", treeList).toJsonString();

        Employee employee = employeeService.selectById(Long.parseLong(eid));
        String jsonString = new ResponseUtils().put("nodeList", treeList).put("employee", employee).toJsonString();

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
