package controller;

import com.google.gson.Gson;
import entity.CommentEntity;
import entity.RegulationEntity;
import entity.UserEntity;
import repository.CommentDao;
import repository.DepartmentDao;
import repository.RegulationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try {

            // get the comments for this employee
            // convert them to json String comments = new Gson.toJson(comments);
            pw.print(new Gson().toJson(comments));
            pw.flush();
        }catch (Exception e){
            System.out.println("Threw exception in CommentServlet");
            pw.print(new Gson().toJson("error"));
            pw.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user == null || user.getAdmin()) {
                throw  new Exception();
            }
            String description = request.getParameter("description");
            int regulationID = Integer.parseInt(request.getParameter("regulation"));
            CommentEntity comment = new CommentEntity();
            comment.setDescription(description);
            comment.setRegulation(RegulationDao.getRegulation(regulationID));
            comment.setUser(user);
            CommentDao.persistComment(comment);
            request.setAttribute("userRegulations", RegulationDao.getUsersRegulations(user));
            request.getRequestDispatcher("user.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("Threw exception in CommentServlet");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
