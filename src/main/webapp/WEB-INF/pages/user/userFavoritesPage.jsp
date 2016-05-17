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
    <div class="container-fluid bg-3 text-center">
        <h3>Favorites products</h3><br>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-sm-4">
                    <p>${product.name}</p>
                    <a href="${pageContext.request.contextPath}/products/${product.id}">
                        <img src="${pageContext.request.contextPath}/resources/images/${product.photo}" alt="Image" width="350">
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
