<%--
  Created by IntelliJ IDEA.
  User: TRAM ANH LAPTOP
  Date: 2/24/2021
  Time: 3:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator">
    <label for="num1">Input number</label>
    <input type="number" name="num1" id="num1">
    <label for="num2">Input number</label>
    <input type="number" name="num2" id="num2">
    <button type="submit" name="operator" value="+">+</button>
    <button type="submit" name="operator" value="-">-</button>
    <button type="submit" name="operator" value="*">*</button>
    <button type="submit" name="operator" value="/">/</button>
</form>
</body>
</html>
