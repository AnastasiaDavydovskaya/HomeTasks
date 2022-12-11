<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
    <jsp:include page="parts/bootstrap.jsp"/>
</head>
<body>
<form:form action="students" method="POST" modelAttribute="student">
    <form>
        <div class="form-group" style="text-align: center">
            <label for="firstName">First name</label>
            <form:input path="firstName" type="text" name="firstName" id="firstName" class="form-control"
                        aria-describedly="firstNameHelp"/>
            <small id="firstNameHelp" class="form-text text-muted">Please provide your name</small>
            <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group" style="text-align: center">
            <label for="lastName">Last name</label>
            <form:input path="lastName" type="text" name="lastName" id="lastName" class="form-control"
                        aria-describedly="lastNameHelp"/>
            <small id="lastNameHelp" class="form-text text-muted">Please provide your last name</small>
            <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group" style="text-align: center">
            <label for="numberOfGroup">Number of group</label>
            <form:input path="numberOfGroup" type="text" name="numberOfGroup" id="numberOfGroup"
                        class="form-control" aria-describedly="numberOfGroupHelp"/>
            <small id="numberOfGroupHelp" class="form-text text-muted">Please provide your number of group</small>
            <form:errors path="numberOfGroup" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group" style="text-align: center">
            <label for="GPA">GPA</label>
            <form:input path="GPA" type="text" name="GPA" id="GPA" class="form-control"
                        aria-describedly="ageHelp"/>
            <small id="GPAHelp" class="form-text text-muted">Please provide your GPA</small>
            <form:errors path="GPA" cssClass="alert alert-danger" element="div"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</form:form>
</body>
<jsp:include page="parts/footer.jsp"/>
</html>