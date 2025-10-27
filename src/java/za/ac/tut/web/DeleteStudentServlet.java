package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.entities.Student;

public class DeleteStudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long stud_number = Long.parseLong(request.getParameter("stud_number"));
        Student student = sfl.find(stud_number);
        String path;

        if (student == null) {
            request.setAttribute("stud_number", stud_number);
            path = "delete_student_not_found.jsp";
        } else {
            sfl.remove(student);
            request.setAttribute("student", student);
            path = "delete_student_output.jsp";
        }

        RequestDispatcher disp = request.getRequestDispatcher(path);
        disp.forward(request, response);
    }
}
