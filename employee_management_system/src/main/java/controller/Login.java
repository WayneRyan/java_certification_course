package controller;

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
        pw.println("hello world");
        pw.println("junk");
        HttpSession session = request.getSession(true);
        session.setAttribute("name", "Welcome");
        session.invalidate();
        if (session.isNew()) {
            System.out.println(session.getAttribute("name"));
        } else {
            System.out.println(session.isNew());
        }
        pw.println("junk2");
        // Check username and passowrd
        // if not match return to login with error
        // set session data
        // if admin goto admin page
        // else if department_head goto department_head page
        // else goto user page
    }
}
