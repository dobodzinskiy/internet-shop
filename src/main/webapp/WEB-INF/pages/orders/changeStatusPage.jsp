<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 28.03.2016
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status | Ishop</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h3>Confirm changing order # ${order.id} status to <b>${status}</b></h3>
    <form action="${pageContext.request.contextPath}/order/all/changeStatus?id=${order.id}&status=${status}" method="post">
        <button type="submit" class="btn btn-primary">Yes</button>
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/order/all">No</a>
    </form>
</div>
</body>
</html>
