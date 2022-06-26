package controller;

import com.google.gson.Gson;
import entity.CommentEntity;
import entity.RegulationEntity;
import entity.UserEntity;
import repository.CommentDao;
import repository.RegulationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user == null || user.getAdmin()) {
                throw new Exception();
            }
            int regulationID = Integer.parseInt(request.getParameter("regulationID"));
            CommentEntity comment = CommentDao.getComment(regulationID, user);
            pw.print(new Gson().toJson(comment == null ? "" : comment.getDescription()));
            pw.flush();
        } catch (Exception e) {
            pw.print(new Gson().toJson(""));
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
                throw new Exception();
            }
            String description = request.getParameter("description");
            int regulationID = Integer.parseInt(request.getParameter("regulation"));
            CommentEntity comment = CommentDao.getComment(regulationID, user);
            if (comment == null) {
                comment = new CommentEntity();
            }
            comment.setDescription(description);
            comment.setRegulation(RegulationDao.getRegulation(regulationID));
            comment.setUser(user);
            CommentDao.persistComment(comment);
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
            request.setAttribute("initialComment", initialComment);
            request.getRequestDispatcher("user.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
