<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 07.06.2022
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Coordinator register</title>
</head>
<body>
REGISTRATION STEPS:<br>
<form:form method="post" modelAttribute="coordinator">
    First name: <form:input path="firstName"/><br>
    <form:errors path="firstName" cssClass="ui-state-error-text"/><br>
    Last name: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="ui-state-error-text"/><br>
    Number: <form:input path="number"/><br>
    <form:errors path="number" cssClass="ui-state-error-text"/><br>
    Password: <form:password path="password"/><br>
    <form:errors path="password" cssClass="ui-state-error-text"/><br>
    <button type="submit">Create Coordinator</button>
</form:form>
</body>
</html>
