package controller;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            System.out.println("getting user from session");
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            System.out.println("got user from session");
            if (user == null || user.getAdmin()) {
                System.out.println("user is null or admin");
                throw  new Exception();
            }
            System.out.println("Hello World");
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
