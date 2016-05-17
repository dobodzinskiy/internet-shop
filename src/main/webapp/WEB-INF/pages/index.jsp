<%--
  Created by IntelliJ IDEA.
  User: Ободзинский
  Date: 12.04.2016
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <script src="build/react.js"></script>
    <script src="build/react-dom.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
</head>
<body>
<jsp:include page="template/navigation-bar.jsp" />
<div id="app-container"></div>
<script type="text/babel" src="../../resources/js/reactApplication.js"></script>
<jsp:include page="template/footer.jsp" />
</body>
</html>
