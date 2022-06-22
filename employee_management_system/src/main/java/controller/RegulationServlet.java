package controller;

import entity.RegulationEntity;
import entity.UserEntity;
import repository.DepartmentDao;
import repository.RegulationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegulationServlet", value = "/RegulationServlet")
public class RegulationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            if (!((UserEntity) request.getSession().getAttribute("user")).getAdmin()) {
                throw  new Exception();
            }
            String description = request.getParameter("description");
            int departmentID = Integer.parseInt(request.getParameter("department"));
            RegulationEntity regulation = new RegulationEntity();
            regulation.setDescription(description);
            regulation.setDepartment(DepartmentDao.getDepartment(departmentID));
            RegulationDao.persistRegulation(regulation);
            request.setAttribute("allDepartments", DepartmentDao.getAllDepartments());
            request.setAttribute("allRegulations", RegulationDao.getAllRegulations());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }catch (Exception e){
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
