package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoApp", value = "/DemoApp")
public class DemoApp extends HttpServlet {

    int num = 100;
    ServletContext sc;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext(); // it will provide us ServletContext reference.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("In Servlet Page<br/>");
        pw.println("Value of num is " + num);
        HttpSession hs = request.getSession();
        hs.setAttribute("obj", num);
        sc.setAttribute("obj2", num);
        hs.invalidate();
//        request.setAttribute("obj", num);
//        RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
//        rd1.forward(request, response);
        response.sendRedirect("index.jsp");
    }
}
