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
   List<Volume> listvolume= (List<Volume>) request.getAttribute("listvolume");
    List<Style> liste= (List<Style>) request.getAttribute("listStyle");
    List<Materiaux> listemateriaux=((List<Materiaux>) request.getAttribute("listMateriaux"));
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
    <form action="/detailsmateriauxstylepost" method="post" >
        <p>selectionner Style:</p>
        <select name="style">
            <% for (int i = 0; i < liste.size(); i++) { %>
            <option  value="<%=liste.get(i).getId() %>"><%= liste.get(i).getNom()%></option>
            <% } %>
        </select>
        <p>selectionner materiaux:</p>

        <select name="materiaux">
            <% for (int i = 0; i < listemateriaux.size(); i++) { %>
            <option  value="<%=listemateriaux.get(i).getId() %>"><%= listemateriaux.get(i).getNom()%></option>
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
