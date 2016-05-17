<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit | Ishop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h3>Change and save</h3>
    <c:choose>
        <c:when test="${product.type == 'Phones'}">
            <%@include file="phone/editPhonePage.jsp" %>
        </c:when>
        <c:when test="${product.type == 'Laptops'}">
            <%@include file="laptop/editLaptopPage.jsp" %>
        </c:when>
        <c:when test="${product.type == 'Computers'}">
            <%@include file="computer/editComputerPage.jsp" %>
        </c:when>
    </c:choose>
</div>

<jsp:include page="../template/footer.jsp" />
</body>
</html>
