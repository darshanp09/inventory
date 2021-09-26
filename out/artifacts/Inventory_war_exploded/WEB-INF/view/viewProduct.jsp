<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/addQuantity" method="post" modelAttribute="product">

        <%--<div class="form-group" hidden>
            <label for="sunday">sun</label>
            <form:input path="sunday" id="sunday" class="form-Control"/>
        </div>

        <div class="form-group" hidden>
            <label for="monday">mon</label>
            <form:input path="monday" id="monday" class="form-Control"/>
        </div>
        <div class="form-group" hidden>
            <label for="tue">tue</label>
            <form:input path="tuesday" id="tue" class="form-Control"/>
        </div>
        <div class="form-group" hidden>
            <label for="wed">wed</label>
            <form:input path="wednesday" id="wed" class="form-Control"/>
        </div>
        <div class="form-group" hidden>
            <label for="thur">thur</label>
            <form:input path="thursday" id="thur" class="form-Control"/>
        </div>
        <div class="form-group" hidden>
            <label for="fri">fri</label>
            <form:input path="friday" id="fri" class="form-Control"/>
        </div>
        <div class="form-group" hidden>
            <label for="sat">sat</label>
            <form:input path="saturday" id="sat" class="form-Control"/>
        </div>--%>

        <div class="form-group" hidden>
            <label for="Quantity">Quantity</label>
            <form:input path="quantitySold" id="Quantity" class="form-Control"/>
        </div>

        <div class="form-group" hidden>
            <label for="ProductId">ProductId</label>
            <form:input path="productId" id="ProductId" class="form-Control"/>
        </div>

        <div class="form-group" hidden>
            <label for="ProductQuantityLeft">ProductId</label>
            <form:input path="quantityLeft" id="ProductQuantityLeft" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="ProductName">ProductName</label>
            <form:input path="productName" id="ProductName" class="form-Control" readonly="true" />
        </div>

        <div class="form-group">
            <label for="QuantitySold">QuantitySold</label>
            <form:input path="quantity" id="QuantitySold" class="form-Control" type="number"/>
        </div>

        <div class="form-group">
            <form:select path="dayOfWeek">
                <form:option value="sunday" label="Sunday"/>
                <form:option value="monday" label="Monday"/>
                <form:option value="tuesday" label="Tuesday"/>
                <form:option value="wednesday" label="Wednesday"/>
                <form:option value="thursday" label="Thursday"/>
                <form:option value="friday" label="Friday"/>
                <form:option value="saturday" label="Saturday"/>
            </form:select>
        </div>


        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@ include file="/WEB-INF/view/template/footer.jsp"%>
