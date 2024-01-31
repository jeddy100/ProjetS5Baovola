<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.example.projets5baovola.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.boot.autoconfigure.cassandra.CassandraProperties" %>
<%@ page import="com.example.projets5baovola.model.Meuble" %>
<%@ page import="com.example.projets5baovola.model.Employe" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/12/2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Employe> liste= (List<Employe>) request.getAttribute("listEmploye");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<H1>Liste des Employes</H1>
<h2>size: <% out.print(liste.size()); %></h2>
            <div class="container">
                <form action="/employesearchpost" method="post">
                    <div class="form-group">
                        <label for="recherche">Recherche:</label>
                        <input type="search" class="form-control" name="recherche" id="recherche" placeholder="Recherche...">
                    </div>
                    <button type="submit" class="btn btn-primary">Rechercher</button>
                </form>

                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Fonction</th>
                        <th scope="col">Paie horaire</th>
                        <th scope="col">Date d'embauche</th>
                        <th scope="col">Rang</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (int i = 0; i < liste.size(); i++) { %>
                    <tr>
                        <td><%= liste.get(i).getNom() %></td>
                        <td><%= liste.get(i).getOuvrier().getFonction() %></td>
                        <td><%= liste.get(i).getPaiehoraire() %></td>
                        <td><%= liste.get(i).getDateEmbauche() %></td>
                        <td><%= liste.get(i).getRang() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
