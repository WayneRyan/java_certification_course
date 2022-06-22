package controller;

import entity.UserEntity;
import repository.DepartmentDao;
import repository.RegulationDao;
import service.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            UserEntity user = Authentication.checkCredentials(request.getParameter("userName"), request.getParameter("password"));
            if (user == null) {
                pw.println("Invalid username and password");
                request.getRequestDispatcher("index.jsp").include(request, response);
            } else {
                request.getSession().setAttribute("user", user);
                if (user.getAdmin()) {
                    request.setAttribute("allDepartments", DepartmentDao.getAllDepartments());
                    request.setAttribute("allRegulations", RegulationDao.getAllRegulations());
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    request.setAttribute("userRegulations", RegulationDao.getUsersRegulations(user));
                    request.getRequestDispatcher("user.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
