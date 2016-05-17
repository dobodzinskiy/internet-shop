<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 15.03.2016
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup | Ishop</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <c:if test="${action == 'signed'}">
        <h2>Successfully. <span class="glyphicon glyphicon-ok"></span> </h2>
        <h2><small>${user.login}, check your email and follow the link to login!</small></h2>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-default">Home</a>
    </c:if>
    <c:if test="${action == 'mailNotValid'}">
        <h3>User with mail <u>"${user.email}"</u> exists in Ishop.</h3>
        <h2><small>Login, please.</small></h2>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">
            <span class="glyphicon glyphicon-log-in"></span> Login
        </a>
    </c:if>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
