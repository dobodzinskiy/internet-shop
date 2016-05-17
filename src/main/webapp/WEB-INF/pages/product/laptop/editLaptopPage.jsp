<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    onload = function description() {
        document.getElementById('pDescription').value = "${product.description}";
        document.getElementById('pPhoto').file = "${product.photo}";
    }
</script>
<form:form class="form-horizontal" role="form"  action="${pageContext.request.contextPath}/products/changeLaptop" method="post" modelAttribute="updateProduct">
    <div class="form-group">
        <label class="control-label col-sm-2" for="pName">Name:</label>
        <div class="col-sm-10">
            <form:input id="pName" type="text" class="form-control" path="name" placeholder="Product name" value="${product.name}"/>
            <form:errors path="name">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="name" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pCompany">Company:</label>
        <div class="col-sm-10">
            <form:input id="pCompany" type="text" class="form-control" path="company" placeholder="Company" value="${product.company}"/>
            <form:errors path="company">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="company" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pPhoto">Photo:</label>
        <div class="col-sm-10">
            <form:input id="pPhoto" type="file" class="form-control" path="photo"/>
            <form:errors path="photo">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="photo" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pPrice">Price:</label>
        <div class="col-sm-10">
            <form:input id="pPrice" type="text" class="form-control" path="price" placeholder="Price" value="${product.price}"/>
            <form:errors path="price">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="price" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pModel">Model:</label>
        <div class="col-sm-10">
            <form:input id="pModel" type="text" class="form-control" path="model" placeholder="Model" value="${product.model}"/>
            <form:errors path="model">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="model" />
                </div>
            </form:errors>
        </div>
    </div>
    <form:hidden path="available" value="${true}"/>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pSize">Size:</label>
        <div class="col-sm-10">
            <form:input id="pSize" type="text" class="form-control" path="size" placeholder="Size" value="${product.size}"/>
            <form:errors path="size">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="size" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pWeight">Weight:</label>
        <div class="col-sm-10">
            <form:input id="pWeight" type="number" class="form-control" path="weight" placeholder="Weight" value="${product.weight}"/>
            <form:errors path="weight">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="weight" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pStorage">Storage:</label>
        <div class="col-sm-10">
            <form:input id="pStorage" type="number" class="form-control" path="storage" placeholder="Storage" value="${product.storage}"/>
            <form:errors path="storage">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="storage" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pRAM">RAM:</label>
        <div class="col-sm-10">
            <form:input id="pRAM" type="number" class="form-control" path="ram" placeholder="RAM" value="${product.ram}"/>
            <form:errors path="storage">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="storage" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pScreen">Screen:</label>
        <div class="col-sm-10">
            <form:input id="pScreen" type="text" class="form-control" path="screen" placeholder="Screen" value="${product.screen}"/>
            <form:errors path="screen">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="screen" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pOS">OS:</label>
        <div class="col-sm-10">
            <form:input id="pOS" type="text" class="form-control" path="os" placeholder="OS" value="${product.os}"/>
            <form:errors path="os">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="os" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pColor">Color:</label>
        <div class="col-sm-10">
            <form:input id="pColor" type="text" class="form-control" path="color" placeholder="Color" value="${product.color}"/>
            <form:errors path="color">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="color" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pProcessor">Processor:</label>
        <div class="col-sm-10">
            <form:input id="pProcessor" type="text" class="form-control" path="processor" placeholder="Processor" value="${product.processor}"/>
            <form:errors path="processor">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="processor" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pLight">Keyboard Light:</label>
        <div id="pLight" class="col-sm-10 radio-menu-item">
            <c:choose>
                <c:when test="${product.keyboardLight == false}">
                    <form:radiobutton path="keyboardLight" value="${true}" />Yes
                    <form:radiobutton path="keyboardLight" value="${false}" checked="checked"/>No
                </c:when>
                <c:otherwise>
                    <form:radiobutton path="keyboardLight" value="${true}" checked="checked"/>Yes
                    <form:radiobutton path="keyboardLight" value="${false}" />No
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pDescription">Description:</label>
        <div class="col-sm-10">
            <form:textarea rows="3" id="pDescription" class="form-control" path="description"/>
            <form:errors path="description">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="description" />
                </div>
            </form:errors>
        </div>
    </div>
    <form:hidden path="id" value="${product.id}" />
    <form:hidden path="type" value="${product.type}" />
    <form:hidden path="available" value="${product.available}" />
    <div id="submitType" class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a href="${pageContext.request.contextPath}/products/availablePage?id=${product.id}" class="btn btn-primary">
                <c:if test="${product.available == true}">Not available</c:if>
                <c:if test="${product.available == false}">Available</c:if>
            </a>
            <button type="submit" class="btn btn-default">Save</button>
            <a href="${pageContext.request.contextPath}/products/${product.type}/options?orderBy=Name" class="btn btn-danger">Cancel</a>
        </div>
    </div>
</form:form>