    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.login} | ishop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />
<div class="container">
    <h2>${user.login}</h2>
    <form:form role="form" action="${pageContext.request.contextPath}/people/update" method="post" modelAttribute="updateUser">
        <div class="form-group">
            <label for="fname">First name:</label>
            <form:input path="firstName" type="text" class="form-control" id="fname" value="${user.firstName}" />
        </div>
        <div class="form-group">
            <label for="lname">Last name:</label>
            <form:input path="lastName" type="text" class="form-control" id="lname"  value="${user.lastName}" />
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <div id="gender" class="radio-menu-item">
                <c:choose>
                    <c:when test="${user.gender == 'Male'}">
                        <form:radiobutton path="gender" value="Male" checked="checked"/>Male
                        <form:radiobutton path="gender" value="Female"/>Female
                    </c:when>
                    <c:when test="${user.gender == 'Female'}">
                        <form:radiobutton path="gender" value="Male" />Male
                        <form:radiobutton path="gender" value="Female" checked="checked"/>Female
                    </c:when>
                    <c:otherwise>
                        <form:radiobutton path="gender" value="Male" />Male
                        <form:radiobutton path="gender" value="Female"/>Female
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" type="email" class="form-control" id="email" value="${user.email}" />
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <form:input path="phone" class="form-control" id="phone" value="${user.phone}" />
        </div>
        <form:hidden path="id" value="${user.id}"/>
        <form:hidden path="password" value="${user.password}" />
        <c:forEach var="role" items="${user.userRoles}" varStatus="loop">
            <form:hidden path="userRoles" value="${role}" />
        </c:forEach>
        <form:hidden path="login" value="${user.login}" />
        <form:hidden path="enabled" value="${user.enabled}" />
        <form:hidden path="staff" value="${user.staff}" />
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="${pageContext.request.contextPath}/people/profile" class="btn btn-danger">Cancel</a>
    </form:form>
</div>
<jsp:include page="../template/footer.jsp" />
</body>
</html>
