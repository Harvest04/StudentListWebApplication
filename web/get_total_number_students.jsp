<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Total Number Of Students Page</title>
    </head>
    <body>
        <h1>Total Number Of Students</h1>
        <p>This is the total number of Students</p>
        <%
        Integer totalNumberOfStudents=(Integer)request.getAttribute("totalNumberOfStudents");
        %>
        <p>The total number of Students is: <%=totalNumberOfStudents%></p>
        <p>Please click <a href="menu.html">here</a> to go back to menu or <a href="EndSessionServlet.do">here</a> to logout</p>

    </body>
</html>
