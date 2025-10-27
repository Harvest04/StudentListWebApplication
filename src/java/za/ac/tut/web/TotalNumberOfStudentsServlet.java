package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;

public class TotalNumberOfStudentsServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer totalNumberOfStudents = sfl.count();
        request.setAttribute("totalNumberOfStudents", totalNumberOfStudents);
        RequestDispatcher disp = request.getRequestDispatcher("get_total_number_students.jsp");
        disp.forward(request, response);
    }
}
