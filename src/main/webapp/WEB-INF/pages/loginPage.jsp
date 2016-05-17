<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> <spring:message code="label.yourLogin" /> | Ishop</title>
    <c:url value="/j_spring_security_check" var="loginUrl" />
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div class="container">
    <h2><spring:message code="label.login" /></h2>

    <form role="form" action="${loginUrl}" method="post">
        <div class="form-group">
            <c:if test="${error != null}">
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <p>Try again, please!</p>
                </div>
            </c:if>
            <label for="login"> <spring:message code="label.yourLogin" />:</label>
            <input class="form-control" id="login" placeholder="Enter login" name="j_username" required>
        </div>
        <div class="form-group">
            <label for="pwd"> <spring:message code="label.password" />:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="j_password" required>
        </div>
        <button type="submit" class="btn btn-default"> <spring:message code="label.submit" /></button>
    </form>
</div>
</body>
</html>
