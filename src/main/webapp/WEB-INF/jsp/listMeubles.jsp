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
    <table>
        <tr>
            <th>nom</th>
            <th>prix de vente</th>
        </tr>
        <% for (int i = 0; i <liste.size() ; i++) {
        %>
        <tr>
            <td><% out.print(liste.get(i).getNom());%></td>
            <td><% out.print(liste.get(i).getPrix_vente());%></td>
            <td>  <a href="detailMeuble/<%=liste.get(i).getId()%>">details</a></td>
        </tr>
        <% }%>
    </table>
        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
