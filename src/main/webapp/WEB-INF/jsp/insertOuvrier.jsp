<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertStyle</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<h1>insertion Ouvrier</h1>
<form action="/ouvrierpost" method="post" >
    <input type="text" name="fonction" placeholder="fonction">
    <input type="number" name="paieHoraire" placeholder="paieHoraire">

    <input type="submit" value="valider">
</form>
        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
