<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${pageName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
    .image {
        overflow:hidden;
    }
    .image img {
        height: 300px;
        width: auto;
        -moz-transition: all 1s ease-out;
        -o-transition: all 1s ease-out;
        -webkit-transition: all 1s ease-out;
    }

    .image img:hover{
        -webkit-transform: scale(1.1);
        -moz-transform: scale(1.1);
        -o-transform: scale(1.1);
    }
</style>
<body>
<jsp:include page="../template/navigation-bar.jsp"/>
<div class="text-center">
    <form class="form-inline" action="${pageContext.request.contextPath}/products/search/options">
        <input type="text" class="form-control" size="50" placeholder="<spring:message code="label.productName" />" name="searchWord">
        <button type="submit" class="btn btn-default"><spring:message code="label.search" /></button>
    </form>
</div>
<div class="container">
    <table class="table">
        <tr>
            <td align="left"> <h2>${type}</h2></td>
            <td align="right">
                <div class="btn-group">
                    <a type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        Order by <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=PriceAsc">Price</a></li>
                        <li><a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=PriceDesc">Price inverse</a></li>
                        <li><a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=Name">Name</a></li>
                        <li><a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=Company">Company</a></li>
                    </ul>
                </div>
            </td>
        </tr>
    </table>

</div>
<div class="container">
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-sm-4">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="text-align: center;">
                        <c:choose>
                            <c:when test="${user.products.contains(product)}">
                                ${product.name} <span class="glyphicon glyphicon-star"></span>
                            </c:when>
                            <c:otherwise>
                                ${product.name}
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="panel-body">
                        <a href="${pageContext.request.contextPath}/products/${product.id}">
                            <c:choose>
                                <c:when test="${product.available == false}">
                                    <div class="image">
                                        <img style="display: block; margin-left: auto;margin-right: auto; opacity: 0.4;"
                                             src="${pageContext.request.contextPath}/resources/images/${product.photo}"/>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="image">
                                        <img style="display: block; margin-left: auto;margin-right: auto;"
                                             src="${pageContext.request.contextPath}/resources/images/${product.photo}"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </div>
                    <div class="panel-footer">
                        <table width="100%">
                            <tr>
                                <td align="left"><fmt:formatNumber>${product.price}</fmt:formatNumber> UAH</td>
                                <sec:authorize access="hasRole('ROLE_MANAGER')">
                                    <td align="right">
                                        <form:form cssStyle="margin: auto;" action="${pageContext.request.contextPath}/products/changePage?id=${product.id}">
                                            <button type="submit" class="btn btn-danger">
                                                <span class="glyphicon glyphicon glyphicon-wrench"></span> Change
                                            </button>
                                        </form:form>
                                    </td>
                                </sec:authorize>
                                <td align="right">
                                    <c:choose>
                                        <c:when test="${product.available == true}">
                                            <form:form cssStyle="margin: auto;" action="${pageContext.request.contextPath}/order/addToCart?productId=${product.id}">
                                                <button type="submit" class="btn btn-primary">
                                                    <span class="glyphicon glyphicon-shopping-cart"></span> Buy
                                                </button>
                                            </form:form>
                                        </c:when>
                                        <c:otherwise>
                                            <p>Not available</p>
                                        </c:otherwise>
                                    </c:choose>

                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div align="center">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=${orderBy}&page=${currentPage - 1}">
                        &laquo;</a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${pagesCount}" var="index">
                <c:choose>
                    <c:when test="${currentPage == index}">
                        <li class="active"><a href="#">${index}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=${orderBy}&page=${index}">${index}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage != pagesCount}">
                <li>
                    <a href="${pageContext.request.contextPath}/products/${type}/options?orderBy=${orderBy}&page=${currentPage + 1}">&raquo;</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>

<jsp:include page="../template/footer.jsp" />
</body>
</html>
