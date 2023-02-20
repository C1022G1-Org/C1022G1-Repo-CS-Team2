<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/2/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="/css/bootstrap.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Accessory</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-6">
            <button type="button" class="btn btn-secondary">
                <a href="/accessory?actions=create2" style="color: white">Create Accessory</a>
            </button>
        </div>
        <div class="col-6">
            <form action="/accessory" method="get">
                <div class="form-group float-left w-75">
                <input type="text" class="form-control" name="accSearch" id="accSearch" aria-describedby="helpId" placeholder="Input accessoryname" value="${accSearch}">
            </div>
                <div class="form-group float-left w-25">
                    <input type="submit" class="form-control btn-secondary" name="search"  value="Search">
                </div>
            </form>

        </div>
    </div>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <td>ID</td>
        <td>Product</td>
        <td>Name</td>
        <td>Supplier</td>
        <td>Photo</td>
        <td>Price</td>
        <td>Quantity</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="accessory" items="${accessoryList}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${accessory.productName}</td>
            <td>${accessory.accessoryName}</td>
            <td>${accessory.supplier}</td>
            <td><img style="height: 20%;width: 20%" src="${accessory.photo}"></td>
            <td>${accessory.price}</td>
            <td>${accessory.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
