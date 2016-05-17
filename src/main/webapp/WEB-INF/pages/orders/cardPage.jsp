<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 22.03.2016
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Card | Ishop</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <form action="${pageContext.request.contextPath}/order/confirm" method="post">
        <h2>Your order:</h2>
        <table class="table">
            <thead>
            <tr>
                <th>№</th>
                <th>Products</th>
                <th>Count</th>
                <th>Price</th>
                <th>Total</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${cart.products}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${product.key.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/order/subtract?productId=${product.key.id}"><span class="glyphicon glyphicon-minus"></span></a>
                            ${product.value}
                        <a href="${pageContext.request.contextPath}/order/add?productId=${product.key.id}"><span class="glyphicon glyphicon-plus"></span></a>
                    </td>
                    <td><fmt:formatNumber>${product.key.price}</fmt:formatNumber> uah</td>
                    <td><fmt:formatNumber>${product.value * product.key.price}</fmt:formatNumber> uah</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <h3>Total : <fmt:formatNumber>${cart.price}</fmt:formatNumber> uah</h3>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.username" var="login" />
            <c:choose>
                <c:when test="${cart.price == 0}">
                    <h3> To confirm order add at least one product to cart!</h3>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary">Confirm order</button>
                    <p> Contact data : ${login}</p>
                </c:otherwise>
            </c:choose>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <p>To confirm your order, you must login or sign up!</p>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/login"><spring:message code="label.login" /></a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/signupPage"><spring:message code="label.signup" /></a>
        </sec:authorize>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-danger">Cancel</a>
    </form>
</div>
</body>
</html>
