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

public class SearchStudentServlet extends HttpServlet {

    @EJB StudentFacadeLocal tfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long stud_number=Long.parseLong(request.getParameter("stud_number"));
        Student student =tfl.find(stud_number);
        String path;
        if(stud_number == null)
        {
            request.setAttribute("stud_number", stud_number);
             path="search_student_not_found.jsp";
        }
        else
        {
            path="serarch_student_output.jsp";
        }
        request.setAttribute("student", student);
        RequestDispatcher disp =request.getRequestDispatcher(path);
        disp.forward(request, response);
    }
}
