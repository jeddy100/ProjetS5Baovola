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
   List<Client> clientList= (List<Client>) request.getAttribute("listClient");
   List<Meuble> meubleList= (List<Meuble>) request.getAttribute("listMeuble");
%>
<html>
<head>
    <title>Title</title>
    <div class="col-md-12  grid-margin stretch-card ">
        <div class="card">
            <div class="card-body">
                <h1>Inserer une vente</h1>
                <div class="container">
                    <form action="/ventepost" method="post">
                        <div class="form-group">
                            <label for="client">Sélectionner un client:</label>
                            <select class="form-control" name="client" id="client">
                                <% for (int i = 0; i < clientList.size(); i++) { %>
                                <option value="<%= clientList.get(i).getId() %>"><%= clientList.get(i).getNom() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="meuble">Sélectionner un meuble:</label>
                            <select class="form-control" name="meuble" id="meuble">
                                <% for (int i = 0; i < meubleList.size(); i++) { %>
                                <option value="<%= meubleList.get(i).getId() %>"><%= meubleList.get(i).getNom() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre de meuble:</label>
                            <input type="number" class="form-control" name="nombre" id="nombre" placeholder="Nombre de meuble">
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
