<%@ page import="com.example.projets5baovola.model.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projets5baovola.model.Materiaux" %>
<%@ page import="com.example.projets5baovola.model.Volume" %>
<%@ page import="com.example.projets5baovola.model.Style" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   List<Volume> listvolume= (List<Volume>) request.getAttribute("listVolume");
    List<Categorie> liste= (List<Categorie>) request.getAttribute("listCategorie");
    List<Style> listeStyle=((List<Style>) request.getAttribute("listStyle"));
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
                <h1>Inserer un meuble</h1>
    <form action="/meublepost" method="post" >
        <p>selectionner categorie:</p>
        <select name="categorie">
            <% for (int i = 0; i < liste.size(); i++) { %>
            <option  value="<%=liste.get(i).getId() %>"><%= liste.get(i).getNom()%></option>
            <% } %>
        </select>
        <p>selectionner Style:</p>

        <select name="style">
            <% for (int i = 0; i < listeStyle.size(); i++) { %>
            <option  value="<%=listeStyle.get(i).getId() %>"><%= listeStyle.get(i).getNom()%></option>
            <% } %>
        </select>
        <p>selectionner un volume:</p>

        <% if (listvolume != null) { %>
        <select name="volume">
            <% for (int i = 0; i < listvolume.size(); i++) { %>
            <option  value="<%=listvolume.get(i).getId() %>"><%= listvolume.get(i).getNomVolume()%></option>
            <% } %>
        </select>
        <%} %>
        <input type="text" name="nom" placeholder="nom du meuble">

        <input type="number" name="prix_vente" placeholder="prix">


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
