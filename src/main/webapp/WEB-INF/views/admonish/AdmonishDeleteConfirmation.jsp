<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 09.06.2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="pages.admonishDeleteConfirmation.title"/> </title>
</head>
<body>
<s:message code="pages.admonishDeleteConfirmation.question"/> ${admonish.admonish} ${admonish.effect} <br>
<a href="/car/delete/${car.id}"><s:message code="pages.admonishDeleteConfirmation.yes"/></a> <br>
<a href="/car/findAll"><s:message code="pages.admonishDeleteConfirmation.no"/></a> <br>
</body>
</html>

