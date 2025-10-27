<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.model.entities.Image"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Students Page</title>
    </head>
    <body>
        <h1>View All Students:</h1>
        <p>
            These are all Students in the database:
        </p>
        <%
           List<Student> students = (List<Student>) request.getAttribute("students");
           int studentCount = 1;
        %>
         <%
            for (Student student : students) {
                Long studentNumber = student.getId();
                String name = student.getName();
                Integer age = student.getAge();
                String gender = student.getGender();
                String date = student.getDate().toString();
                List<String> subjects = student.getSubjects();
                StringBuilder subjectsDetailsBuilder = new StringBuilder();
                for (int i = 0; i < subjects.size(); i++) {
                    subjectsDetailsBuilder.append(subjects.get(i));
                    if (i < subjects.size() - 1) {
                        subjectsDetailsBuilder.append(", ");
                    }
                }
                String subjectsDetails = subjectsDetailsBuilder.toString();
                List<Image> image = student.getImages();
        %>
        
        <table>
            <tbody>
                <tr>
                    <td><u><b>Student Number:</b></u> </td>
                    <td><%=studentNumber%></td>
                </tr>
                <tr>
                    <td><u><b>Student Name:</b></u> </td>
                    <td><%=name%></td>
                </tr>
                
                <tr>
                    <td><u><b>Student Age:</b></u> </td>
                    <td><%=age%></td>
                </tr>
                <tr>
                    <td><u><b>Student Gender:</b></u> </td>
                    <td><%=gender%></td>
                </tr>
                <tr>
                    <td><u><b>Student Date Added:</b></u> </td>
                    <td><%=date%></td>
                </tr>
                <tr>
                    <td><u><b>Student Subjects:</b></u> </td>
                    <td><%=subjectsDetails%></td>
                </tr>
                <%
                    for (int i = 0; i < image.size(); i++) {
                        Image img = image.get(i);
                        String imageSource = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(img.getImage_source());

                %>
                <tr>
                    <td><u><b>Image:</b></u> </td>
                    <td><img src="<%=imageSource%>" height="200px" width="200px"></td>
                </tr>
                <%
                        }
                %>
                <tr>
                    <td colspan="2">-------------------------------------<%=studentCount%>---------------------------------------</td>
                </tr>
                <%
                    studentCount++;
                    }
                %>
            </tbody>
        </table>
            <p>Please click <a href="menu.html">here</a> to go back to menu or <a href="EndSessionServlet.do">here</a> to logout</p>
    </body>
</html>
