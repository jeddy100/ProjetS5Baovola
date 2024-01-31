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
                <div class="container">
                    <form action="/meublepost" method="post">
                        <div class="form-group">
                            <label for="categorie">Sélectionner une catégorie:</label>
                            <select class="form-control" name="categorie" id="categorie">
                                <% for (int i = 0; i < liste.size(); i++) { %>
                                <option value="<%= liste.get(i).getId() %>"><%= liste.get(i).getNom() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="style">Sélectionner un style:</label>
                            <select class="form-control" name="style" id="style">
                                <% for (int i = 0; i < listeStyle.size(); i++) { %>
                                <option value="<%= listeStyle.get(i).getId() %>"><%= listeStyle.get(i).getNom() %></option>
                                <% } %>
                            </select>
                        </div>
                        <% if (listvolume != null) { %>
                        <div class="form-group">
                            <label for="volume">Sélectionner un volume:</label>
                            <select class="form-control" name="volume" id="volume">
                                <% for (int i = 0; i < listvolume.size(); i++) { %>
                                <option value="<%= listvolume.get(i).getId() %>"><%= listvolume.get(i).getNomVolume() %></option>
                                <% } %>
                            </select>
                        </div>
                        <% } %>
                        <div class="form-group">
                            <label for="nom">Nom du meuble:</label>
                            <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom du meuble">
                        </div>
                        <div class="form-group">
                            <label for="prix_vente">Prix de vente:</label>
                            <input type="number" class="form-control" name="prix_vente" id="prix_vente" placeholder="Prix de vente">
                        </div>
                        <div class="form-group">
                            <label for="tempsConfection">Temps de confection (en heures):</label>
                            <input type="text" class="form-control" name="tempsConfection" id="tempsConfection" placeholder="Temps de confection">
                        </div>
                        <button type="submit" class="btn btn-primary">Valider</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp" />

</head>
<body>

</body>
</html>
