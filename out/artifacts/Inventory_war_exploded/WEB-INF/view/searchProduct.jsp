<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<div class="container">
    <div class="page-header">
        <h1>All Products</h1>
        <br><br>
        <a href="<c:url value="/addProduct" />" class="btn btn-primary">Add Product</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>ProductId</th>
            <th>ProductName</th>
            <th>Price</th>
            <th>QuantitySold</th>
            <th>TotalProductSale</th>
            <th>QuantityLeft</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.quantitySold}</td>
                <td>${product.totalProductSale}</td>
                <td>${product.quantityLeft}</td>
                <td><a href="<c:url value="/viewProduct/${product.productId}" />"
                ><span class="glyphicon glyphicon-info-sign"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>