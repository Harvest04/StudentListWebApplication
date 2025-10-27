<!DOCTYPE html>
<html>
<head>
    <title>Display Average Age of Males</title>
</head>
<body>
    <h1>Display Average Age of Males</h1>
    <%
        Double averageAge = (Double) request.getAttribute("averageAge");
    %>
    <p>The average age of male students is: <%= averageAge %></p>
    <br>
    <a href="display_avg_age_males.html">Back to Form</a>
</body>
</html>
