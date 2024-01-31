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
    int nombreMeublePossible= (int) request.getAttribute("nombreMeublePossible");
%>
<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
            <H1>Nombre de fabrication possible</H1>
            <p>vous pouvez creer :<% out.print(nombreMeublePossible); %> </p>



        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
