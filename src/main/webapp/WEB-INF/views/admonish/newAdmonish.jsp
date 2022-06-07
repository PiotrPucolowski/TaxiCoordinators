<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 07.06.2022
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Admonish register</title>
</head>
Add New Admonish:<br>
<form:form method="post" modelAttribute="admonish">
    Car Plate: <form:input path="carPlate"/><br>
    <form:errors path="carPlate" cssClass="ui-state-error-text"/><br>
    Coordinator Number <form:input path="CoordinatorNumber"/><br>
    <form:errors path="coordinatorNumber" cssClass="ui-state-error-text"/><br>
    Amonish: <form:input path="admonish"/><br>
    <form:errors path="admonish" cssClass="ui-state-error-text"/><br>
    Effect: <form:input path="effect"/><br>
    <form:errors path="effect" cssClass="ui-state-error-text"/><br>
    <button type="submit">Create new Admonish</button>
</form:form>

<body>

</body>
</html>
