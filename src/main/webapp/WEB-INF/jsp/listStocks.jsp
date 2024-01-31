<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.example.projets5baovola.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.boot.autoconfigure.cassandra.CassandraProperties" %>
<%@ page import="com.example.projets5baovola.model.Meuble" %>
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
    List<Materiaux> liste= (List<Materiaux>) request.getAttribute("materiauxList");
    List<Double> nb= (List<Double>) request.getAttribute("listenbmateriaux");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<H1>Liste des stocks</H1>
<h2>size: <% out.print(liste.size()); %></h2>
            <div class="container">
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Nombre</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (int i = 0; i < liste.size(); i++) { %>
                    <tr>
                        <td><%= liste.get(i).getNom() %></td>
                        <td><%= nb.get(i) %></td>
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
