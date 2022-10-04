<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 04/10/2022
  Time: 08.39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bruger side</title>
</head>
<body>

<h1> velkommen til din brugerside ${requestScope.navn}</h1>

dit sessionid er ${requestScope.sessionId}


<br>
<br>
<br>

<form action="TilføjEnmeServlet">
    <label for="enme">Emen:</label><br>
    <input type="text" id="enme" name="enme" value="Ølbong"><br>
    <input type="submit" value="tilføj">
</form>

du har nu tilføjer ${sessionScope.antal} emner til din liste
<br>

(Session : )  de tilføjede emer er følgende ${sessionScope.emneListe}
<br>
(request : ) de tilføjede emner er følgende ${requestScope.emneListeReq}


udskriver listen via jstl:
<br>

<c:forEach items="${sessionScope.emneListe}" var="emne">

    ${emne}
    <br>



</c:forEach>




<br>
<br>
<br>
<br>

<form action="logudServlet">

    <input type="submit" value="log af">
</form>




</body>
</html>
