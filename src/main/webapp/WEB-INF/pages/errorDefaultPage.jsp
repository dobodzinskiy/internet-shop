<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div class="container">
    <h3>
        Something went wrong! <span class="glyphicon glyphicon-remove"></span>
    </h3>
    <p>
        Please, contact I-shop administrator.
    </p>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-default">
        <span class="glyphicon glyphicon-home"></span> Home
    </a>
</div>
</body>
</html>
