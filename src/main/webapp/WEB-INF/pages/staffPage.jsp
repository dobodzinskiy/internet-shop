<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Workers | ishop</title>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div class="container">
    <h2>Workers in I-shop:</h2>
    <a href="${pageContext.request.contextPath}/staff/addPage" class="btn btn-primary">Add new</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/home">Home</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Roles</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>
                    <c:forEach var="role" items="${user.userRoles}">
                        ${role} <br>
                    </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/staff/delete?id=${user.id}" method="post">
                        <button type="submit" class="btn btn-danger">Dismiss</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
