<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 19/12/2023
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<h1>insertion style</h1>
<form action="/volumepost" method="post" >
    <input type="text" name="nomVolume" placeholder="nom">
    <input type="submit" value="valider">
</form>
        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
