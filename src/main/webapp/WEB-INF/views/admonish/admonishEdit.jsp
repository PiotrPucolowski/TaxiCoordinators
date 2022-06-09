<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 09.06.2022
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><s:message code="pages.editAdmonish.title"/></title>
</head>
<body>
<form:form modelAttribute="admonish" action="/admonish/editConfirmation">
    <s:message code="pages.createAdmonishForm.admonish"/>: <form:input path="admonish"/> <form:errors path="admonish"/><br>
    <s:message code="pages.createAdmonishForm.effect"/>: <form:input path="effect"/> <form:errors path="effect"/><br>
    <form:hidden path="id"/>
    <form:button><s:message code="pages.createAdmonishForm.submit"/></form:button>
</form:form>
</body>
</html>
