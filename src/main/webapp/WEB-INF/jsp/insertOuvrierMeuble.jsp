<%@ page import="java.util.List" %>
<%@ page import="com.example.projets5baovola.model.*" %><%--
  Created by IntelliJ IDEA.
  User: Jeddy
  Date: 12/12/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="template/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Ouvrier> ouvrierList=((List<Ouvrier>) request.getAttribute("ouvrierList"));
    Long idmeuble= (Long) request.getAttribute("idmeuble");
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
    <form action="/materiauxOuvrierpost" method="post" >

        <p>selectionner un ouvrier:</p>

        <% if (ouvrierList != null) { %>
        <select name="ouvrier">
            <% for (int i = 0; i < ouvrierList.size(); i++) { %>
            <option  value="<%=ouvrierList.get(i).getId() %>"><%= ouvrierList.get(i).getFonction()%></option>
            <% } %>
        </select>
        <%} %>
        <input type="number" name="nombreOuvrier" placeholder="quantite">
        <input type="hidden" name="idmeuble" value="<%=idmeuble %>">


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
