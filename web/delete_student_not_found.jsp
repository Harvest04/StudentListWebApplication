<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Not Found Page</title>
    </head>
    <body>
        <%
        Long stud_number=(Long)request.getAttribute("stud_number");
        %>
        <h1>Student not found</h1>
        <p>The student with student number <%=stud_number%> is not found in the database!</p>
        
        <p>Please click <a href="menu.html">here</a> to go back to menu or <a href="EndSessionServlet.do">here</a> to logout</p>

    </body>
</html>
