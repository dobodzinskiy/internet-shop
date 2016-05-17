<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 25.03.2016
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add staff | Ishop</title>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div class="container">
    <h2>Add new worker to Ishop:</h2>
    <form:form action="${pageContext.request.contextPath}/staff/add" method="post" modelAttribute="user">
        <div class="form-group">
            <label for="login"><spring:message code="label.yourLogin" />:</label>
            <form:input path="login" class="form-control" id="login" placeholder="Enter login" />
        </div>
        <div class="form-group">
        <label for="pwd"><spring:message code="label.password" />:</label>
        <form:input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password" />
        </div>
        <div class="form-group">
            <label for="Role">Role:</label>
            <select id="Role" name="Role" style="width: 200px; border-radius: 7px;">
                <option value="ROLE_ADMIN">Administrator</option>
                <option value="ROLE_MANAGER">Manager</option>
                <option value="ROLE_MODERATOR">Moderator</option>
            </select>
        </div>
        <form:hidden path="phone" value="" />
        <form:hidden path="email" value="" />
        <button type="submit" class="btn btn-default"><spring:message code="label.submit" /></button>
    </form:form>
</div>
</body>
</html>
