<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Data Bank</title>
</head>
<body>
<h1><%= "Velkommen til din online Data Bank!" %>
</h1>
<br/>

<h1> Login for eksistende brugere </h1>

${requestScope.loginBesked}

<form action="LoginServlet" method="get">  <%-- bemærk ingen stråstreg ! altså sådan en her ik. huske get som default "/"--%>
    <label for="navn">Navn:</label><br>
    <input type="text" id="navn" name="navn" value=""><br>
    <label for="kode">indtask kode:</label><br>
    <input type="text" id="kode" name="kode" value=""><br><br>
    <input type="submit" value="login">
</form>

<h1>eller opret dig som brugere</h1>

${requestScope.besked}

<form action="LoginServlet" method="post"> <%-- bemærk ingen stråstreg ! altså sådan en her ik "/"--%>
    <label for="OpretNavn">Navn:</label><br>
    <input type="text" id="OpretNavn" name="OpretNavn" value=""><br>
    <label for="kode1">angiv kode:</label><br>
    <input type="text" id="kode1" name="kode1" value=""><br>
    <label for="kode2">skriv koden igen:</label><br>
    <input type="text" id="kode2" name="kode2" value=""><br><br>
    <input type="submit" value="opret">
</form>


<h1>login som administrator</h1>
<form action="AdminLoginServlet">
    <input type="submit" value="Administrator Login">
</form>





</body>
</html>