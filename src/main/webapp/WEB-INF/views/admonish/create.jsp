<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><s:message code="pages.create-admonish.admonish"/></title>
</head>
<body>
<spring:form modelAttribute="createAdmonishForm">
    <div>
        <label><s:message code="pages.create-admonish.form.admonish"/>: <spring:input path="admonish"/><spring:errors path="admonish" element="span"/></label>
    </div>
    <div>
        <label><s:message code="pages.create-admonish.form.driver"/>: <spring:input path="driver" type="driver" min="500" max="3000"
                                    step="1"/><spring:errors path="drivers" element="span"/></label>
    </div>
    <div>
        <label>Main Coordinator:
            <spring:select path="mainCoordinato.number" items="${coordinators}" itemValue="number"
                           itemLabel="Number"/>
            or <spring:input path="mainCoordinator.firstName" placeholder="Main coordinator first name"/>
            <spring:input path="mainCoordinator.lastName" placeholder="Main coordinator last name"/>
        </label>
    </div>
    <div>
        Additional coordinators:
        <div>
            <label>First name: <input name="firstName"/> </label>
            <label>Last name: <input name="lastName"/></label>
            <label>Number: <input name="number"/></label>
            <button name="addCoordinator">Add coordinator</button>
        </div>
        <c:forEach items="${createAdmonishForm.coordinators}" var="coordinator" varStatus="status">
            <div>
                <input type="text" name="coordinators[${status.index}].firstName"
                       value="${createAdmonishForm.coordinators[status.index].firstName}"
                       placeholder="First name"/>
                <input type="text" name="coordinators[${status.index}].lastName"
                       value="${createAdmonishForm.coordinators[status.index].lastName}"
                       placeholder="Last name"/>
                <input type="text" name="coordinators[${status.index}].number"
                       value="${createAdmonishForm.coordinators[status.index].number}"
                       placeholder="Number"/>
                <button name="removeCoordinator" value="${status.index}">Remove</button>
            </div>
        </c:forEach>
    </div>
    <div>
        <label>Categories: <spring:select path="categories" items="${categories}" multiple="true"
                                          itemLabel="name" itemValue="id"/></label>
    </div>
    <spring:button name="createAdmonish">Create admonish</spring:button>
</spring:form>
</body>
</html>
