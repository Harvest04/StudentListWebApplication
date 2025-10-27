<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error age</title>
    </head>
    <body>
        <h1>Error</h1>
        <p>Error Occured</p>
        <%
          String errMessage=(String)exception.getMessage();
        %>
        <p>Error: <%=errMessage%></p>
        <p>Please click <a href="menu.html">here</a> to go back to menu or <a href="EndSessionServlet.do">here</a> to logout</p>

    </body>
</html>
