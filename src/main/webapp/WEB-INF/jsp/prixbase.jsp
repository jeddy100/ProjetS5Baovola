<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/01/2024
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp" />

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>inserer prix de bases</h1>
<form action="/prixbasepost" method="post" >

<input type="number" placeholder="prix1" name="prix1">
<input type="number" placeholder="prix2" name="prix2">
<input type="submit" value="valider">
</form>
<jsp:include page="template/footer.jsp" />

</body>
</html>
