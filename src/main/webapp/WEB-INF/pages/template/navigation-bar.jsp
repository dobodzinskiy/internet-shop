<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse" style="border-radius: 0;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                I-Shop
            </a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><spring:message code="label.products" /><span class="caret"></span> </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/products/Computers/options?orderBy=Name"><spring:message code="label.computers" /></a></li>
                    <li><a href="${pageContext.request.contextPath}/products/Laptops/options?orderBy=Name"><spring:message code="label.laptops" /></a></li>
                    <li><a href="${pageContext.request.contextPath}/products/Phones/options?orderBy=Name"><spring:message code="label.phones" /></a></li>
                </ul>
            </li>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Add product <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/products/addPage?type=Phones">Phone</a></li>
                        <li><a href="${pageContext.request.contextPath}/products/addPage?type=Laptops">Laptop</a></li>
                        <li><a href="${pageContext.request.contextPath}/products/addPage?type=Computers">Computer</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/order/all">Orders</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_MODERATOR')">
                <li><a href="${pageContext.request.contextPath}/people/">Clients</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="${pageContext.request.contextPath}/staff/">Staff</a></li>
            </sec:authorize>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <span class="glyphicon glyphicon-wrench"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/home?lang=en"> en </a></li>
                    <li><a href="${pageContext.request.contextPath}/home?lang=ru"> ru </a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <span class="glyphicon glyphicon-shopping-cart"></span> <spring:message code="label.cart" /> </a>
                <ul class="dropdown-menu" style="width: 220px;">
                    <c:forEach var="product" items="${cart.products}">
                        <li>
                            <div class="table-responsive">
                                <table class="table" style="font-size: smaller">
                                    <tr>
                                        <td> <img width="25px" src="${pageContext.request.contextPath}/resources/images/${product.key.photo}"/> </td>
                                        <td align="left">
                                            <a href="${pageContext.request.contextPath}/products/${product.key.id}">${product.key.name}</a>
                                        </td>
                                        <td align="right">${product.value} x <fmt:formatNumber>${product.key.price}</fmt:formatNumber></td>
                                        <td><a href="${pageContext.request.contextPath}/order/removeFromCard?productId=${product.key.id}"><span class="glyphicon glyphicon-remove"></span></a> </td>
                                    </tr>
                                </table>
                            </div>
                        </li>
                    </c:forEach>
                    <li>
                        <div class="table-responsive">
                            <table class="table" style="font-size: smaller">
                                <tr valign="middle">
                                    <td align="left">Total : <fmt:formatNumber>${cart.price}</fmt:formatNumber> uah</td>
                                    <td align="right"><a href="${pageContext.request.contextPath}/order/cart" class="btn btn-primary">Order</a></td>
                                </tr>
                            </table>
                        </div>
                    </li>
                </ul>
            </li>
        <sec:authorize access="!isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/signupPage"><span class="glyphicon glyphicon-user"></span> <spring:message code="label.signup" /></a></li>
                <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="label.login" /> </a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.username" var="login" />
                <li><a href="${pageContext.request.contextPath}/people/profile">
                    <span class="glyphicon glyphicon-user"></span> ${login} </a></li>
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <li><a href="${logoutUrl}"><span class="glyphicon glyphicon-log-out"></span> <spring:message code="label.logout" /></a></li>
        </sec:authorize>
        </ul>
    </div>
</nav>
</body>
</html>
