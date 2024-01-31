<%@ page import="com.example.projets5baovola.model.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projets5baovola.model.Materiaux" %>
<%@ page import="com.example.projets5baovola.model.Volume" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   List<Volume> listvolume= (List<Volume>) request.getAttribute("listvolume");
    List<Categorie> liste= (List<Categorie>) request.getAttribute("listCategorie");
    List<Materiaux> listemateriaux=((List<Materiaux>) request.getAttribute("listMateriaux"));
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
                <h1>inserer stock</h1>
    <form action="/mouvementstockpost" method="post" >
        <p>selectionner materiaux:</p>

        <select name="materiaux">
            <% for (int i = 0; i < listemateriaux.size(); i++) { %>
            <option  value="<%=listemateriaux.get(i).getId() %>"><%= listemateriaux.get(i).getNom()%></option>
            <% } %>
        </select>

        <input type="number" name="quantiteMateriaux" placeholder="quantite">


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
