<%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
            <h1>insertion categories</h1>
<form action="/categoriepost" method="post" >
    <input type="text" name="nom" placeholder="nom">
    <input type="submit" value="valider">
</form>
        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp"/>




