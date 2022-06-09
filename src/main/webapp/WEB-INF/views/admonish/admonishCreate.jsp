<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 09.06.2022
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><s:message code="pages.createAdmonish.title"/></title>
</head>
<body>
<form:form modelAttribute="admonish">
    <s:message code="pages.createAdmonish.admonish"/>: <form:input path="admonish"/> <form:errors path="admonish"/><br>
    <s:message code="pages.createAdmonish.effect"/>: <form:input path="effect"/> <form:errors path="effect"/><br>
    <form:button><s:message code="pages.createAdmonishForm.submit"/></form:button>
</form:form>
</body>
</html>
