package za.ac.tut.web;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.entities.Student;

import java.io.IOException;

public class DisplayYoungestStudentServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student youngestStudent = studentFacade.getYoungestStudent();

        request.setAttribute("youngestStudent", youngestStudent);

        request.getRequestDispatcher("display_youngest_student_output.jsp").forward(request, response);
    }
}
