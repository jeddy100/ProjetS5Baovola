<%@ page import="java.util.List" %>
<%@ page import="com.example.projets5baovola.model.*" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   List<Genre> genreList= (List<Genre>) request.getAttribute("listGenre");
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
                <h1>Inserer un Client</h1>
    <form action="/clientpost" method="post" >
        <p>selectionner genre:</p>
        <select name="genre">
            <% for (int i = 0; i < genreList.size(); i++) { %>
            <option  value="<%=genreList.get(i).getId() %>"><%= genreList.get(i).getGenre()%></option>
            <% } %>
        </select>
        <input type="text" name="nom" placeholder="nom de l employe">

        <input type="submit" value="valider">
    </form>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp" />

</head>
<body>

</body>
</html>
