<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 09.06.2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><s:message code="pages.home.title"/></title>
</head>
<body>
<s:message code="pages.home.welcome"/> <br>
<a href="/registration"><s:message code="pages.home.registrationLink"/></a> <br>
<a href="/login"><s:message code="pages.home.loginLink"/></a><br>
<a href="/admonish/add">Add Admonish</a><br>
<a href="/admonish/findAll">Show all admonish</a>
</body>
</html>
