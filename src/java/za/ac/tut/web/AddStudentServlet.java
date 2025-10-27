package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.entities.Image;
import za.ac.tut.model.entities.Student;

@MultipartConfig
public class AddStudentServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal tfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long stud_number = Long.parseLong(request.getParameter("stud_number"));
        String stud_name = request.getParameter("stud_name");
        Integer stud_age = Integer.parseInt(request.getParameter("stud_age"));
        String stud_gender = request.getParameter("stud_gender");
        Collection<Part> stud_parts = request.getParts();
        List<Image> images = new ArrayList<>();

        for (Part part : stud_parts) {
            if (part.getContentType() != null) {
                String image_name = part.getSubmittedFileName();
                InputStream part_stream = part.getInputStream();
                byte[] image_blob = getPartBlob(part_stream);
                images.add(new Image(image_name, image_blob));
            }
        }

        String[] stud_subjects = request.getParameterValues("stud_subjects");
        List<String> subjects = new ArrayList<>(Arrays.asList(stud_subjects));

        Student student = new Student(stud_number, stud_name, stud_age, stud_gender, subjects, images);
        request.setAttribute("student", student);
        tfl.create(student);
        RequestDispatcher disp = request.getRequestDispatcher("add_Student_output.jsp");
        disp.forward(request, response);

    }

    private byte[] getPartBlob(InputStream part_stream) {
        byte[] image_blob = null;
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int value;

        try {
            while ((value = part_stream.read(buffer)) != -1) {
                baos.write(buffer, 0, value);
            }
            image_blob = baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return image_blob;
    }
}


