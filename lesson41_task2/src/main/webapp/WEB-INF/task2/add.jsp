<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add task</title>
    <jsp:include page="parts/bootstrap.jsp"/>
</head>
<body>
<form:form action="addTask" method="POST" modelAttribute="task">
    <form>
        <div class="form-group">
            <label for="description">Task:</label>
            <form:input path="description" type="text" name="description" id="description" class="form-control"
                        aria-describedly="descriptionHelp"/>
            <small id="descriptionHelp" class="form-text text-muted">Please provide your task</small>
            <form:errors path="description" cssClass="alert alert-danger" element="div"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</form:form>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>