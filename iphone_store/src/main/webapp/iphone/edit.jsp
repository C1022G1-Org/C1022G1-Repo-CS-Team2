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
    <a href="/user"> BACK TO LIST USER</a>
</p>
<form action="/user?action=edit" method="post">
    <fieldset>
        <legend>User Information</legend>
        <table class="table table-striped">
            <tr>
                <td>id</td>
                <td><input type="hidden" name="id" value="${iphone.id}"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
