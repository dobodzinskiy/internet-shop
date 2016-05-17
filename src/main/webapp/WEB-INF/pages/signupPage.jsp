<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 15.03.2016
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.signup" /> | i-shop</title>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div class="container">
    <h2><spring:message code="label.signup" /></h2>
    <form:form action="${pageContext.request.contextPath}/signup" method="post" modelAttribute="user">
        <div class="form-group">
            <label for="login"><spring:message code="label.yourLogin" />*:</label>
            <form:input path="login" class="form-control" id="login" placeholder="Enter login" />
            <form:errors path="login">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="login" />
                </div>
            </form:errors>
            <br>
            <c:if test="${loginError != null}">
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <p>${loginError}</p>
                </div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="email"><spring:message code="label.email" />*:</label>
            <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter email"  />
            <form:errors path="email">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="email" />
                </div>
            </form:errors>
        </div>
        <div class="form-group">
            <label for="phone"><spring:message code="label.phone" />*:</label>
            <form:input path="phone" class="form-control" id="phone" placeholder="Enter phone number"  />
            <form:errors path="phone">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="phone" />
                </div>
            </form:errors>
        </div>
        <div class="form-group">
            <label for="pwd"><spring:message code="label.password" />*:</label>
            <form:input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password"  />
            <form:errors path="password">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="password" />
                </div>
            </form:errors>
        </div>
        <button type="submit" class="btn btn-default"><spring:message code="label.submit" /></button>
    </form:form>
</div>
<jsp:include page="template/footer.jsp" />
</body>
</html>
