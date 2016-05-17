<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2><c:out value="${product.name}" /></h2>
<div class="panel panel-default">
    <div class="panel-heading"><spring:message code="label.model" />: <c:out value="${product.model}" /></div>
    <div class="panel-body">
        <table class="table table-responsive">
            <tr>
                <td colspan="2">
                    <img id="image" style="display: block; margin-left: auto;margin-right: auto; width: 300px;"
                         src="${pageContext.request.contextPath}/resources/images/${product.photo}"/>
                    <script>
                        onload = function bigger() {
                            document.getElementById('image').onclick = function() {
                                document.getElementById('image').style.width = '900';
                                document.getElementById("information").style.display = 'none';
                            };
                            document.getElementById('image').ondblclick = function() {
                                document.getElementById('image').style.width = '300';
                                document.getElementById("information").style.display = 'block';
                            }
                        }
                    </script>
                </td>
                <td id="information" rowspan="2" width="500px" height="600">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#about">About</a></li>
                        <li><a data-toggle="tab" href="#description">Details</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="about" class="tab-pane fade in active">
                            <h3>Description</h3>
                            <h3><small><c:out value="${product.description}" /></small></h3>
                        </div>

                        <div id="description" class="tab-pane fade">
                            <br>
                            <table class="table table-hover">
                                <tr>
                                    <td><b>Company</b></td>
                                    <td><c:out value="${product.company}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Weight</b></td>
                                    <td><c:out value="${product.weight}" /></td>
                                </tr>
                                <tr>
                                <td><b>Size</b></td>
                                <td><c:out value="${product.size}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Storage</b></td>
                                    <td><c:out value="${product.storage}" /></td>
                                </tr>
                                <tr>
                                    <td><b>RAM</b></td>
                                    <td><c:out value="${product.ram}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Screen</b></td>
                                    <td><c:out value="${product.screen}" /></td>
                                </tr>
                                <tr>
                                    <td><b>OS</b></td>
                                    <td><c:out value="${product.os}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Color</b></td>
                                    <td><c:out value="${product.color}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Processor</b></td>
                                    <td><c:out value="${product.processor}" /></td>
                                </tr>
                                <tr>
                                    <td><b>DualSim</b></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.dualSim == true}">Yes</c:when>
                                            <c:otherwise>No</c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>Sim types</b></td>
                                    <td><c:out value="${product.simType}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Message types</b></td>
                                    <td><c:out value="${product.messageType}" /></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <fmt:formatNumber>${product.price}</fmt:formatNumber> UAH
                </td>
                <td align="right">
                    <sec:authorize access="isAuthenticated()">
                        <c:choose>
                            <c:when test="${isFavorite}">
                                <form action="${pageContext.request.contextPath}/products/removeFromFavorite?productId=${product.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Remove from favorites</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="${pageContext.request.contextPath}/products/addToFavorite?productId=${product.id}" method="post">
                                    <button type="submit" class="btn btn-primary">To favorites</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </sec:authorize>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/order/addToCart?productId=${product.id}">To cart</a>
                </td>
            </tr>
        </table>
    </div>
</div>
