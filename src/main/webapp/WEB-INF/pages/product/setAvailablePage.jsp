<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change | Ishop</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <c:choose>
        <c:when test="${product.available == true}">
            <h2>Confirm setting <c:out value="${product.name}"/> not available</h2>
        </c:when>
        <c:otherwise>
            <h2>Confirm setting <c:out value="${product.name}"/> available</h2>
        </c:otherwise>
    </c:choose>
    <form action="${pageContext.request.contextPath}/products/available?id=${product.id}" method="post">
        <button type="submit" class="btn btn-default">Yes</button>
        <a class="btn btn-default" href="${pageContext.request.contextPath}/products/changePage?id=${product.id}">No</a>
    </form>
</div>
</body>
</html>
