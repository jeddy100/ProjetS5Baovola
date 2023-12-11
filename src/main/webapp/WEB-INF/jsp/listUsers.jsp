<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.example.projets5baovola.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.boot.autoconfigure.cassandra.CassandraProperties" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 09/12/2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Users> liste= (List<Users>) request.getAttribute("listUsers");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<H1>qwedpfnhqwodhqwdhwq</H1>
<h2>size: <% out.print(liste.size()); %></h2>
    <table>
        <tr>
            <th>nom</th>
            <th>prenom</th>
        </tr>
        <% for (int i = 0; i <liste.size() ; i++) {
        %>
        <tr>
            <td><% out.print(liste.get(i).getNom());%></td>
            <td><% out.print(liste.get(i).getPrenom());%></td>
        </tr>
        <% }%>
    </table>

</body>
</html>
