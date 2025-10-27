<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.model.entities.Image"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Youngest Student Output Page</title>
    </head>
    <body>

        <%

            Student student = (Student) request.getAttribute("youngestStudent");
            String stud_name = student.getName();
            Long stud_number = student.getId();
            Integer stud_age = student.getAge();
            String stud_gender = student.getGender();
            List<Image> images = student.getImages();
            List<String> subjects = student.getSubjects();

        %>
        <h1>Youngest Student Output</h1>
        <p>
            Here are the details:
        </p>

        <table>

            <tbody>
                <tr>
                    <td>Student Number: </td>
                    <td><%=stud_number%></td>
                </tr>
                <tr>
                    <td>Student Name:</td>
                    <td><%=stud_name%></td>
                </tr>
                <tr>
                    <td>Student Age:</td>
                    <td><%=stud_age%></td>
                </tr>
                <tr>
                    <td>Student Gender:</td>
                    <td><%=stud_gender%></td>
                </tr>
                <tr>
                    <td>Student Subjects: </td>
                    <td>
                        <ol>
                            <%
                                for (int i = 0; i < subjects.size(); i++) {
                                    String subject = subjects.get(i);
                            %>
                            <li><%=subject%></li>
                                <%
                                    }
                                %>
                        </ol>
                    </td>
                </tr>
                <tr>
                    <td>Student Images:</td>
                    <td>
                        <%
                            for (int i = 0; i < images.size(); i++) {
                                String image_name = images.get(i).getName();
                                String image_source = "data:image/png;base64," + Base64.getEncoder().encodeToString(images.get(i).getImage_source());;
                        %>
                        <img src=<%=image_source%> width="200px" height="200px">
                        <%
                            }
                        %>
                    </td>
                </tr>
            </tbody>
        </table>

        <p>Please click <a href="menu.html">here</a> to go back to menu or <a href="EndSessionServlet.do">here</a> to logout</p>
    </body>
</html>
