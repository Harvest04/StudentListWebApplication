package za.ac.tut.web;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DisplayMaleFemaleTotalServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long totalStudents = studentFacade.getTotalNumberOfStudents();
        Long maleCount = studentFacade.getTotalNumber("Male");
        Long femaleCount = studentFacade.getTotalNumber("Female");

        Double malePercentage = (totalStudents != 0) ? (double) maleCount / totalStudents * 100 : 0.0;
        Double femalePercentage = (totalStudents != 0) ? (double) femaleCount / totalStudents * 100 : 0.0;

        Map<String, Double> percentages = new HashMap<>();
        percentages.put("Male", malePercentage);
        percentages.put("Female", femalePercentage);

        request.setAttribute("percentages", percentages);

        request.getRequestDispatcher("display_male_female_total_output.jsp").forward(request, response);
    }
}
