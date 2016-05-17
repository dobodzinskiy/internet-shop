<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 28.03.2016
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders | Ishop</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h2>All orders in Ishop:</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Order #</th>
            <th>Login</th>
            <th>Products</th>
            <th>Price</th>
            <th>Date</th>
            <th>Status</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td><a href="${pageContext.request.contextPath}/order/all/profile?login=${order.username}" class="btn btn-link">${order.username}</a> </td>
                <td>
                    <c:forEach var="product" items="${order.products}">
                        ${product.key.name} <small>x ${product.value}</small>
                        <br>
                    </c:forEach>
                </td>
                <td><fmt:formatNumber>${order.price}</fmt:formatNumber></td>
                <td>${order.date.toLocaleString()}</td>
                <td>${order.orderState}</td>
                <td>
                    <div class="btn-group-vertical">
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/order/all/contact?login=${order.username}">Contact user</a>
                        <div class="btn-group">
                            <a type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                Change status <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="${pageContext.request.contextPath}/order/all/changeStatusPage?id=${order.id}&status=Accepted">Accepted</a></li>
                                <li><a href="${pageContext.request.contextPath}/order/all/changeStatusPage?id=${order.id}&status=InProgress">InProgress</a></li>
                                <li><a href="${pageContext.request.contextPath}/order/all/changeStatusPage?id=${order.id}&status=Shipped">Shipped</a></li>
                                <li><a href="${pageContext.request.contextPath}/order/all/changeStatusPage?id=${order.id}&status=Delivered">Delivered</a></li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
