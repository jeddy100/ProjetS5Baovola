<%@ page import="com.example.projets5baovola.model.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projets5baovola.model.Materiaux" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categorie> liste= (List<Categorie>) request.getAttribute("listCategorie");
    List<Materiaux> listemateriaux=((List<Materiaux>) request.getAttribute("listMateriaux"));
%>
<html>
<head>
    <title>Title</title>
    <form action="/detailsmateriauxcategoriepost" method="post" >
        <p>selectionner categorie:</p>
        <select>
            <% for (int i = 0; i < liste.size(); i++) { %>
            <option name="categorie" value="<%=liste.get(i) %>"><%= liste.get(i).getNom()%></option>
            <% } %>
        </select>
        <p>selectionner materiaux:</p>

        <select>
            <% for (int i = 0; i < listemateriaux.size(); i++) { %>
            <option name="materiaux" value="<%=listemateriaux.get(i) %>"><%= listemateriaux.get(i).getNom()%></option>
            <% } %>
        </select>
        <input type="number" name="quantiteMateriaux" placeholder="quantite">


        <input type="submit" value="valider">
    </form>
</head>
<body>

</body>
</html>
