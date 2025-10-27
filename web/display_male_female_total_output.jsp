<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
    <title>Display Male and Female Percentages</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Male and Female Percentages</h1>
    <p>Percentage of Males: <%= request.getAttribute("percentages") != null ? ((Map<String, Double>) request.getAttribute("percentages")).get("Male") : "N/A" %> %</p>
    <p>Percentage of Females: <%= request.getAttribute("percentages") != null ? ((Map<String, Double>) request.getAttribute("percentages")).get("Female") : "N/A" %> %</p>
    <p>Please click <a href="menu.html">here</a> to go back to the menu or <a href="EndSessionServlet.do">here</a> to logout.</p>
</body>
</html>
