<form:form class="form-horizontal" role="form"  action="${pageContext.request.contextPath}/products/addPhone" method="post" modelAttribute="productDto">
    <div class="form-group">
        <label class="control-label col-sm-2" for="pName">Name:</label>
        <div class="col-sm-10">
            <form:input id="pName" type="text" class="form-control" path="name" placeholder="Product name"/>
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
            <form:input id="pCompany" type="text" class="form-control" path="company" placeholder="Company"/>
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
            <form:input id="pPrice" type="text" class="form-control" path="price" placeholder="Price"/>
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
            <form:input id="pModel" type="text" class="form-control" path="model" placeholder="Model"/>
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
            <form:input id="pSize" type="text" class="form-control" path="size" placeholder="Size"/>
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
            <form:input id="pWeight" type="number" class="form-control" path="weight" placeholder="Weight"/>
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
            <form:input id="pStorage" type="number" class="form-control" path="storage" placeholder="Storage"/>
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
            <form:input id="pRAM" type="number" class="form-control" path="ram" placeholder="RAM"/>
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
            <form:input id="pScreen" type="text" class="form-control" path="screen" placeholder="Screen"/>
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
            <form:input id="pOS" type="text" class="form-control" path="os" placeholder="OS"/>
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
            <form:input id="pColor" type="text" class="form-control" path="color" placeholder="Color"/>
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
            <form:input id="pProcessor" type="text" class="form-control" path="processor" placeholder="Processor"/>
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
        <label class="control-label col-sm-2" for="pDual">Dual Sim:</label>
        <div id="pDual" class="col-sm-10 radio-menu-item">
            <form:radiobutton path="dualSim" value="${true}" />Yes
            <form:radiobutton path="dualSim" value="${false}"/>No
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pSim">Sim type:</label>
        <div class="col-sm-10">
            <form:input id="pSim" type="text" class="form-control" path="simType" placeholder="Sim type"/>
            <form:errors path="simType">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="simType" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pMessage">Message type:</label>
        <div class="col-sm-10">
            <form:input id="pMessage" type="text" class="form-control" path="messageType" placeholder="Message type"/>
            <form:errors path="messageType">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="messageType" />
                </div>
            </form:errors>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="pDescription">Description:</label>
        <div class="col-sm-10">
            <form:textarea rows="3" id="pDescription" class="form-control" path="description" placeholder="Description"/>
            <form:errors path="description">
                <br>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <form:errors path="description" />
                </div>
            </form:errors>
        </div>
    </div>
    <div id="submitType" class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="${pageContext.request.contextPath}/home" class="btn btn-danger">Cancel</a>
        </div>
    </div>
</form:form>