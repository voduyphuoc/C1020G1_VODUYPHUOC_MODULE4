<%--
  Created by IntelliJ IDEA.
  User: TRAM ANH LAPTOP
  Date: 2/26/2021
  Time: 6:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form:form modelAttribute="emailBox" method="post" action="/detail">
    <p>Languages : <span><form:select type="text" path="language" items="${listLanguages}"/></span></p>
    <p>Page Size :
    <p>Page Size :
        <span>Show</span>
        <span><form:select type="text" path="pageSize" items="${page_size}"/></span>
        <span>email per page</span>
    </p>
    <p>Spams Filter :
        <input type="checkbox" name="spamsFilter" checked="checked" value="true"/>
        <lable>enable per page</lable>
    </p>
    <p>Signature :</p>
    <textarea name="signature" id="" cols="30" rows="10"></textarea>
    <br>
    <input type="submit" value="Update"/>
</form:form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>