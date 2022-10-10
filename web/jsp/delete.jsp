<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete/user" method="POST">
    Number to delete:</br><input type="tel" name="to-delete"></br>
    <input type="submit" value="Submit"></br>
</form>
<a href="/jsp/list.jsp">See list users</a>
</body>
</html>
