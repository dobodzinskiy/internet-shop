<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Shop | Add</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h2>Adding new product</h2>
    <h3>Category : ${productDto.type}</h3>
    <c:choose>
        <c:when test="${productDto.type == 'Phones'}">
            <%@include file="phone/addPhonePage.jsp" %>
        </c:when>
        <c:when test="${productDto.type == 'Laptops'}">
            <%@include file="laptop/addLaptopPage.jsp" %>
        </c:when>
        <c:when test="${productDto.type == 'Computers'}">
            <%@include file="computer/addComputerPage.jsp" %>
        </c:when>
    </c:choose>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
