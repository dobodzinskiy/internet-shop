<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.welcome" /> | Shop</title>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp"/>
<div class="container">
    <div class="page-header">
        <h1>Welcome to Ishop</h1>
        <p>This shop is great study project designed and developed by D. Obodzinskiy</p>
    </div>
    <div id="myCarousel" style="height: 600px;" class="carousel slide" data-ride="carousel" data-interval="2000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <c:forEach begin="0" end="${products.size() - 1}" var="index">
                <c:choose>
                    <c:when test="${index == 0}">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    </c:when>
                    <c:otherwise>
                        <li data-target="#myCarousel" data-slide-to="${index}"></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <c:forEach var="product" items="${products}" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index == 1}">
                        <div class="item active">
                            <a href="${pageContext.request.contextPath}/products/${product.id}">
                                <img style="margin-left: auto; margin-right: auto; height: 90%;"
                                     src="${pageContext.request.contextPath}/resources/images/${product.photo}">
                            </a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="item">
                            <a href="${pageContext.request.contextPath}/products/${product.id}">
                                <img style="margin-left: auto; margin-right: auto; height: 90%;"
                                     src="${pageContext.request.contextPath}/resources/images/${product.photo}">
                            </a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
</body>
</html>
