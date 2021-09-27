<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/addProduct" method="post" modelAttribute="product">

        <div class="form-group" hidden>
            <label for="ProductId">ProductId</label>
            <form:input path="productId" id="ProductId" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="ProductName">ProductName</label>
            <form:input path="productName" id="ProductName" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">SellingPrice</label>
            <form:input path="price" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="BasePrice">BasePrice</label>
            <form:input path="basePrice" id="BasePrice" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="quantityLeft" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="ScanCode">ScanCode</label>
            <form:input path="productScanCode" id="ScanCode" class="form-Control"/>
        </div>

            <div class="form-group">
                <form:select path="productCategory">
                    <form:option value="Candy" label="Candy"/>
                    <form:option value="Snacks" label="Snacks"/>
                    <form:option value="Soda" label="Soda"/>
                    <form:option value="VendingMachine" label="VendingMachine"/>
                    <form:option value="SportsDrink" label="SportsDrink"/>
                    <form:option value="KidsDrinks" label="KidsDrinks"/>
                    <form:option value="E-cig" label="E-cig"/>
                    <form:option value="Tobaco" label="Tobaco"/>
                    <form:option value="Food" label="Food"/>
                    <form:option value="Chips" label="Chips"/>
                    <form:option value="Coffee" label="Coffee"/>
                    <form:option value="Tea" label="Tea"/>
                    <form:option value="Juice" label="Juice"/>
                    <form:option value="Water" label="Water"/>
                    <form:option value="Ice-Cream" label="Ice-Cream"/>
                    <form:option value="Medicine" label="Medicine"/>
                    <form:option value="Other" label="Other"/>
                </form:select>
            </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>

    </div>
<%@ include file="/WEB-INF/view/template/footer.jsp"%>