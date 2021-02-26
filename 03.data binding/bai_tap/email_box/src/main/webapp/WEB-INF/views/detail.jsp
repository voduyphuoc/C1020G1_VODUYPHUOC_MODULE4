<%--
  Created by IntelliJ IDEA.
  User: TRAM ANH LAPTOP
  Date: 2/26/2021
  Time: 6:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Language:</td>
        <td>${emailBox.language}</td>
    </tr>
    <tr>
        <td>Page Size  :</td>
        <td>${emailBox.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter:</td>
        <td>${emailBox.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${emailBox.signature}</td>
    </tr>
</table>
</body>
</html>
