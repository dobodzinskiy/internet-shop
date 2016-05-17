<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 17.03.2016
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.login} | ishop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <table class="table borderless">
        <thead>
        <tr>
            <th>
                <h2><spring:message code="label.yourLogin" />: <c:out value="${user.login}"/></h2>
            </th>
            <th>
                <a href="${pageContext.request.contextPath}/people/profileEdit" class="btn btn-primary">Change profile</a>
                <a href="${pageContext.request.contextPath}/people/history" class="btn btn-primary">Order history</a>
                <a href="${pageContext.request.contextPath}/people/favorites" class="btn btn-primary">Favorites</a>
            </th>
        </tr>
        </thead>
        <tr>
            <td>Name:</td>
            <td><c:out value="${user.firstName}"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><c:out value="${user.lastName}"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><c:out value="${user.gender}"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><c:out value="${user.email}"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><c:out value="${user.phone}"/></td>
        </tr>
    </table>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
