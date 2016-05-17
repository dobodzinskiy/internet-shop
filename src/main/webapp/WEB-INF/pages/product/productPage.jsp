<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${product.name}</title>
</head>
<body>
<jsp:include page="../template/navigation-bar.jsp" />

<div class="container">
    <c:choose>
        <c:when test="${product.type == 'Phones'}">
            <%@include file="phone/phonePage.jsp" %>
        </c:when>
        <c:when test="${product.type == 'Laptops'}">
            <%@include file="laptop/laptopPage.jsp" %>
        </c:when>
        <c:when test="${product.type == 'Computers'}">
            <%@include file="computer/computerPage.jsp" %>
        </c:when>
    </c:choose>
    <div class="panel panel-default">
        <div class="panel-body">
            <sec:authorize access="isAuthenticated()">
                <h4><spring:message code="label.leaveComment" />:</h4>
                <form:form action="${pageContext.request.contextPath}/products/addComment" method="post" modelAttribute="comment">
                    <div class="form-group">
                        <form:textarea path="text" class="form-control" rows="3" />
                        <form:errors path="text">
                            <br>
                            <div class="alert alert-danger">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <form:errors path="text" />
                            </div>
                        </form:errors>
                    </div>
                    <div class="form-group">
                        <label for="rate"><spring:message code="label.rate" />:</label>
                        <form:select path="rate" cssStyle="width: 100px; border-radius: 8px;">
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                        </form:select>
                    </div>
                    <form:hidden path="productId" value="${product.id}"/>
                    <button type="submit" class="btn btn-success"><spring:message code="label.submit" /></button>
                </form:form>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <h4><spring:message code="label.logToComment" /></h4>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/login"><spring:message code="label.login" /></a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/signupPage"><spring:message code="label.signup" /></a>
                <br>
                <hr>
            </sec:authorize>
            <c:choose>
                <c:when test="${comments.size() == 0}">
                    <p><spring:message code="label.noComments" /></p>
                    <hr>
                </c:when>
                <c:otherwise>
                    <p><span class="badge">${comments.size()}</span> <spring:message code="label.comments" />:</p><br>
                    <c:forEach var="comment" items="${comments}" varStatus="loop">
                        <div class="col-sm-10">
                            <h4>
                                <c:out value="${comment.username}"/>
                                <small>${comment.date.toLocaleString()}</small>
                            </h4>
                            <p><c:out value="${comment.text}"/></p>
                            <h5>Rated: <c:out value="${comment.rate}"/> <span class="glyphicon glyphicon-star"></span> </h5>
                            <br>
                            <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                <form action="${pageContext.request.contextPath}/products/removeComment?id=${comment.id}" method="post">
                                    <button type="submit" class="btn btn-danger">Remove</button>
                                </form>
                            </sec:authorize>
                            <hr>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
