package za.ac.tut.web;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;

import java.io.IOException;

public class DisplayAverageAgeFemalesServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Double averageAge = studentFacade.getAverage("Female"); // Corrected method call for females

        request.setAttribute("averageAge", averageAge);
        request.getRequestDispatcher("display_avg_age_females_output.jsp").forward(request, response);
    }
}
