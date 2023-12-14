<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertmateriaux</title>
</head>
<body>
<h1>insertion Materiaux</h1>

    <form action="/materiauxpost" method="post" >
        <input type="text" name="nom" placeholder="nom">
        <input type="text" name="unite" placeholder="unite">
        <input type="number" name="prix" placeholder="prix unitaire">
        <input type="submit" value="valider">
    </form>
</body>
</html>
