<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Block</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <c:if test="${user.enabled == true}">
        <h3>Block user <c:out value="${user.login}"/> ? </h3>
        <form action="${pageContext.request.contextPath}/people/block?id=${user.id}" method="post">
            <button type="submit" class="btn btn-default">Yes</button>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/people/">No</a>
        </form>
    </c:if>
    <c:if test="${user.enabled == false}">
        <h3>Unblock user <c:out value="${user.login}"/>  ? </h3>
        <form action="${pageContext.request.contextPath}/people/unblock?id=${user.id}" method="post">
            <button type="submit" class="btn btn-default">Yes</button>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/people/">No</a>
        </form>
    </c:if>
</div>
</body>
</html>
