<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/01/2024
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/beneficepost" method="post" >
    <h1>inserer les benefices</h1>
<input type="number" placeholder="prix1" name="prix1">
<input type="number" placeholder="prix2" name="prix2">
<input type="submit" value="valider">
</form>
<jsp:include page="template/footer.jsp" />


</body>
</html>
