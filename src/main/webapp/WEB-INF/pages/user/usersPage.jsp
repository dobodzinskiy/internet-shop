<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Shop | Clients</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h2>Clients</h2>
    <p>All these people are users of our shop:</p>
    <table class="table table-hover" style="vertical-align: middle; align-self: center;">
        <thead>
        <tr>
            <th>#</th>
            <th>Login</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Gender</th>
            <th>Mail</th>
            <th>Phone number</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>
                    <div class="btn-group-vertical">
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/people/historyAdmin?login=${user.login}">Order history</a>
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/people/contact?login=${user.login}">Contact</a>
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/people/blockConfirm?id=${user.id}">
                            <c:if test="${user.enabled == true}">
                                Block
                            </c:if>
                            <c:if test="${user.enabled == false}">
                                Unblock
                            </c:if>
                        </a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>