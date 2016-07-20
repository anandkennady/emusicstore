<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
    $(document).ready(function(){

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10, -1], [1,2,3,5,10, "All"]]
        });
    });
    </script>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Supplier Inventory Page</h1>


            <p class="lead">This is the Supplier inventory page:</p>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Proto Thumb</th>
                <th>Supplier Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${suppliers}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${supplier.supplierId}.png" />" alt="image" style="width:100%"/></td>
                    <td>${supplier.supplierName}</td>
                    <td>${supplier.supplierCategory}</td>
                    <td>${supplier.supplierCondition}</td>
                    <td>${supplier.supplierPrice} USD </td>
                    <td>
                        <a href="<spring:url value="/supplier/viewSupplier/${supplier.supplierId}" />"><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/supplier/deleteSupplier/${supplier.supplierId}" />"><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/supplier/editSupplier/${supplier.supplierId}" />"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/supplier/addSupplier" />" class="btn btn-primary">Add Supplier</a>
</div>
</div>
</div>

</body>
</html>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>