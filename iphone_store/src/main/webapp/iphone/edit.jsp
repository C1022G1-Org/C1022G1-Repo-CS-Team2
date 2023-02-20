<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/20/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="/js/bootstrap.min.js"></script>

<html>
<head>
    <title>EDIT</title>
</head>
<body>
<h1>Edit user</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/iphone"> BACK TO LIST IPHONE</a>
</p>
<form action="/iphone?action=edit" method="post" >
    <fieldset>
        <legend>User Information</legend>
        <table class="table table-striped">
            <tr>
                <td>id</td>
                <td><input type="hidden" name="id" value="${iphone.id}"></td>
            </tr>
            <td><select name="id_lsp">
                <option value="1">Điện Thoại</option>
                <option value="2">Phụ kiện</option>
            </select>
            </td>
            <tr>
                <td>iphoneName</td>
                <td><input type="text" name="iphoneName" value="${iphone.iphoneName}"></td>
            </tr>

            <tr>
                <td>supplier</td>
                <td><input type="text" name="supplier" value="${iphone.supplier}"></td>
            </tr>

            <tr>
                <td>photo</td>
                <td><input type="text" name="photo" value="${iphone.photo}"></td>
            </tr>

            <tr>
                <td>price</td>
                <td><input type="text" name="price" value="${iphone.price}"></td>
            </tr>

            <tr>
                <td>quantity</td>
                <td><input type="text" name="quantity" value="${iphone.quantity}"></td>
            </tr>

            <tr>
                <td></td>
                <td><button type="submit">Edit iphone</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
