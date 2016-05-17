<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 16.03.2016
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>history | ishop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
    .table > tbody > tr > td {
        vertical-align: middle;
    }
</style>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h3>Order history</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Order id</th>
            <th>Products</th>
            <th>Date</th>
            <th>State</th>
            <th>price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>
                    <c:forEach var="product" items="${order.products}">
                        <table class="table">
                            <tr>
                                <td style="width: 280px;">
                                    <p>
                                        <a href="${pageContext.request.contextPath}/products/${product.key.id}">
                                        <c:out value="${product.key.name}"/>
                                        </a>
                                    </p>
                                </td>
                                <td>
                                    <img width="80px;" src="${pageContext.request.contextPath}/resources/images/${product.key.photo}" />
                                        ${product.value} x <fmt:formatNumber>${product.key.price}</fmt:formatNumber>
                                </td>
                            </tr>
                        </table>
                    </c:forEach>
                </td>
                <td>${order.date.toLocaleString()}</td>
                <td>${order.orderState}</td>
                <td><fmt:formatNumber>${order.price}</fmt:formatNumber></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
