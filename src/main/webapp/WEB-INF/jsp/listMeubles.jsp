<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.example.projets5baovola.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.boot.autoconfigure.cassandra.CassandraProperties" %>
<%@ page import="com.example.projets5baovola.model.Meuble" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/12/2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Meuble> liste= (List<Meuble>) request.getAttribute("listMeuble");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<H1>Liste des Meubles</H1>
<h2>size: <% out.print(liste.size()); %></h2>
            <div class="container">
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Prix de vente</th>
                        <th scope="col">Détails</th>
                        <th scope="col">Insérer ouvrier</th>
                        <th scope="col">Statistique</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (int i = 0; i < liste.size(); i++) { %>
                    <tr>
                        <td><%= liste.get(i).getNom() %></td>
                        <td><%= liste.get(i).getPrix_vente() %></td>
                        <td><a href="detailMeuble/<%= liste.get(i).getId() %>" class="btn btn-primary">Détails</a></td>
                        <td><a href="insertOuvrierMeuble/<%= liste.get(i).getId() %>" class="btn btn-success">Insérer ouvrier</a></td>
                        <td><a href="statMeuble/<%= liste.get(i).getId() %>" class="btn btn-info">Statistique</a></td>
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
