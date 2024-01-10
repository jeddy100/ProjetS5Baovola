<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/12/2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>insertion utilisateur</h1>
<form action="/userpost" method="post" >
    <input type="text" name="nom" placeholder="nom">
    <input type="text" name="prenom" placeholder="prenom">
    <input type="submit" value="valider">
</form>
<jsp:include page="template/footer.jsp" />


</body>
</html>
