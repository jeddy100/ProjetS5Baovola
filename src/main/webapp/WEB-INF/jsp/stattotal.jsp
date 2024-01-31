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
    Integer ventehomme= (Integer) request.getAttribute("ventehomme");
    Integer ventefemme= (Integer) request.getAttribute("ventefemme");
    int ventetotalmeuble= (int) request.getAttribute("ventetotalmeuble");
%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<html>
<head>
    <title>ListUser</title>
</head>
<body>
<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
            <h2>Statistiques des Ventes</h2>

            <table border="1">
                <tr>
                    <th>Vente Homme</th>
                    <th>Vente Femme</th>
                    <th>Vente Total</th>
                </tr>
                <tr>
                    <td id="venteHomme"><% out.print((ventehomme/ventetotalmeuble)*100); %>%</td>
                    <td id="venteFemme"><% out.print((ventefemme/ventetotalmeuble)*100); %>%</td>
                    <td id="venteTotal"><% out.print(ventetotalmeuble); %></td>
                </tr>
            </table>
            <canvas id="myChart" width="400" height="400"></canvas>

            <script>
                // Exemple de données (vous devez remplacer ces valeurs par celles que vous obtenez du backend)
                var venteHomme = <%= ventehomme %>;
                var venteFemme = <%= ventefemme %>;
                var venteTotal = <%= ventetotalmeuble %>;

                // Calcul des pourcentages
                var pourcentageHomme = (venteHomme / venteTotal) * 100;
                var pourcentageFemme = (venteFemme / venteTotal) * 100;

                // Mettez à jour les cellules du tableau avec les pourcentages
                document.getElementById("venteHomme").innerText = pourcentageHomme.toFixed(2) + "%";
                document.getElementById("venteFemme").innerText = pourcentageFemme.toFixed(2) + "%";
                document.getElementById("venteTotal").innerText = venteTotal;

                // Créer un graphique
                var ctx = document.getElementById('myChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ['Vente Homme', 'Vente Femme'],
                        datasets: [{
                            data: [pourcentageHomme, pourcentageFemme],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.8)', // Rouge
                                'rgba(54, 162, 235, 0.8)', // Bleu
                            ],
                        }],
                    },
                });
            </script>

        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp" />


</body>
</html>
