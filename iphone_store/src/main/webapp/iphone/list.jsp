<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/2/2023
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="/css/bootstrap.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
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
            <button type="button" class="btn-secondary">
                <a href="/iphone?action=create" style="color: white">Create iphone product</a>
            </button>
        </div>
        <div class="col-6">
            <form action="/iphone" method="get">
                <div class="form-group float-left w-75">
                    <input type="text" class="form-control" name="nameSearch" id="nameSearch" aria-describedby="helpId" placeholder="Input iphonename" value="${nameSearch}">
                </div>
                <div class="float-left w-25">
                    <input type="submit" class="btn-secondary" name="search" value="Search">
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
        <td>Quatity</td>
        <td>EDIT</td>
        <td>DELETE</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="iphone" items="${iphoneList}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${iphone.productName}</td>
            <td>${iphone.iphoneName}</td>
            <td>${iphone.supplier}</td>
            <td><img style="height: 20%;width: 20%" src="${iphone.photo}"></td>
            <td>${iphone.price}</td>
            <td>${iphone.quantity}</td>
            <td><!-- Button trigger modal -->
                <button type="button" class="btn btn-primary">
                    <a href="/iphone?action=edit&id=${iphone.id}" style="color: white; text-decoration: none; height: 15px" >Edit</a>
                </button>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#modelId" onclick="deleteIphone(${iphone.id})">
                    Delete
                </button>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete Iphone</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Do you sure wanna delete it ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form action="/iphone" method="get">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="deleteIphone" id="deleteIphone">
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>
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

<script>
    function deleteIphone(id){
        document.getElementById("deleteIphone").value = id;
    }
</script>
</body>
</html>