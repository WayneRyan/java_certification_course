package controller;

import service.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession(true);
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (Validation.checkCredentials(userName, password)){

        } else {

        }
        // Check username and passowrd
        // if not match return to login with error
        // set session data
        // if admin goto admin page
        // else if department_head goto department_head page
        // else goto user page
    }
}
