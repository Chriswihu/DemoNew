<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 05-Oct-22
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<br>
<h1>Login, kun for Administratorer!</h1>

<form action="AdminLoginServlet" method="get">  <%-- bemærk ingen stråstreg ! altså sådan en her ik. huske get som default "/"--%>
    <label for="navn">Navn:</label><br>
    <input type="text" id="navn" name="navn" value=""><br>
    <label for="kode">indtask kode:</label><br>
    <input type="text" id="kode" name="kode" value=""><br><br>
    <input type="submit" value="login">
</form>

</body>
</html>
