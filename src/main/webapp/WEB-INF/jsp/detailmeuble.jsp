<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.example.projets5baovola.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.boot.autoconfigure.cassandra.CassandraProperties" %>
<%@ page import="com.example.projets5baovola.model.Meuble" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.projets5baovola.model.Materiaux" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/12/2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    double PU= (double) request.getAttribute("PU");
   List<Materiaux>materiauxList= (List<Materiaux>) request.getAttribute("materiauxList");
   List<Double>quantiteList= (List<Double>) request.getAttribute("quantiteList");
   Long idmeuble= (Long) request.getAttribute("idmeuble");
   double prixDeProduction= (double) request.getAttribute("prixDeProduction");
   double benefices= (double) request.getAttribute("benefices");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
            <div class="container">
                <h1>Prix de fabrication du Meuble: <%= PU %></h1>

                <% for (int i = 0; i < materiauxList.size(); i++) { %>
                <p>Materiaux: <%= materiauxList.get(i).getNom() %> - Quantité: <%= quantiteList.get(i) %></p>
                <% } %>

                <p>Prix de production: <%= prixDeProduction %></p>
                <p>Bénéfice: <%= benefices %></p>

                <form action="/nombremeublepost" method="post">
                    <div class="form-group">
                        <label for="quantite">Quantité de meuble:</label>
                        <input type="number" class="form-control" name="quantite" id="quantite" placeholder="Quantité de meuble">
                    </div>
                    <input type="hidden" name="idmeuble" value="<%= idmeuble %>">
                    <button type="submit" class="btn btn-primary">Créer</button>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
