<%--
  Created by IntelliJ IDEA.
  User: pucek
  Date: 09.06.2022
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="pages.admonishList.title"/></title>
</head>
<body>
<table>
    <thead>
    <c:forEach items="${admonishList}" var ="admonish">
        <tr>
            <td>${admonish.admonish}</td>
            <td>${admonish.effect}</td>
            <td><a href="admonish/deleteConfirmation/${admonish.id}"><s:message code="pages.admonishList.delete"/></a></td>
            <td><a href="admonish/edit/${admonish.id}"><s:message code="pages.admonishList.edit"/></a> </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
