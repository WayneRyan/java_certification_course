package controller;

import entity.CommentEntity;
import entity.RegulationEntity;
import entity.UserEntity;
import repository.CommentDao;
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
import java.util.List;

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
                enterHomepage(request, response, user);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            enterHomepage(request, response, user);
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void enterHomepage(HttpServletRequest request, HttpServletResponse response, UserEntity user) throws ServletException, IOException {
        if (user.getAdmin()) {
            request.setAttribute("allDepartments", DepartmentDao.getAllDepartments());
            request.setAttribute("allRegulations", RegulationDao.getAllRegulations());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            List<RegulationEntity> userRegulations = RegulationDao.getUsersRegulations(user);
            String initialComment = "";
            if (userRegulations.size() > 0) {
                CommentEntity theComment = CommentDao.getComment(userRegulations.get(0).getId(), user);
                if (theComment != null) {
                    initialComment = theComment.getDescription();
                }
            }
            request.setAttribute("initialComment", initialComment);
            request.setAttribute("userRegulations", userRegulations);
            request.getRequestDispatcher("user.jsp").forward(request, response);
        }
    }
}
