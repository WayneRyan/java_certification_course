package com.controller;

import com.bean.Login;
import com.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login ll = new Login();
        ll.setEmail(email);
        ll.setPassword(password);
        LoginService ls = new LoginService();
        String result = ls.checkUser(ll);
        RequestDispatcher rd1 = request.getRequestDispatcher("success.jsp");
        RequestDispatcher rd2 = request.getRequestDispatcher("failure.jsp");
        if(result.equals("success")){
            rd1.forward(request,response);
        }else{
            rd2.forward(request,response);
        }

    }
}
