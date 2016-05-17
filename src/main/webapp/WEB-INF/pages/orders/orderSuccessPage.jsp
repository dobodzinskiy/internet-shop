<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 24.03.2016
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order accepted!</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h2>Your order was successfully confirmed!</h2>
    <p>Check your email and wait, out manager will contact you. Thank you :)</p>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-default">Home</a>
</div>
</body>
</html>
