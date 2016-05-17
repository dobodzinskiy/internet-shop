<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Done!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h3>
        <c:out value="${name}"/> was successfully ${action} ! <span class="glyphicon glyphicon-ok"/>
    </h3>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-default">
        <span class="glyphicon glyphicon-home"></span> Home
    </a>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
