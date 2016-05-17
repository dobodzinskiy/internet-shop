<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dobodzinskiy
  Date: 16.03.2016
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact | Ishop</title>

</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <form action="${pageContext.request.contextPath}/people/send?userId=${user.id}" method="post">
        <h2>Send email to <c:out value=""/>${user.login}:</h2>
        <textarea class="form-control" rows="4" name="message" placeholder="Type your message here..."  required></textarea>
        <br>
        <button type="submit" class="btn btn-primary"> Send </button>
        <a class="btn btn-cancel" href="${pageContext.request.contextPath}/people/">Cancel</a>
    </form>
</div>
</body>
</html>
