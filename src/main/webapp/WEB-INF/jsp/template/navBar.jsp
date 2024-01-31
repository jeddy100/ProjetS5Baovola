<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid page-body-wrapper">

  <nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
      <li class="nav-item">
        <a class="nav-link" href="">
          <i class="mdi mdi-grid-large menu-icon"></i>
          <span class="menu-title">Dashboard</span>
        </a>
      </li>
<%--     Meubles--%>
      <li class="nav-item nav-category">Meuble</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#meuble" aria-expanded="false"
           aria-controls="meuble">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Meuble</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="meuble">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertMeuble">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listMeuble">liste</a></li>

          </ul>
        </div>
      </li>

<%--      Style--%>


      <li class="nav-item nav-category">Style</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#Style" aria-expanded="false"
           aria-controls="Style">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Style</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="Style">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertStyle">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertDetailsMateriauxStyle">materiaux</a></li>

          </ul>
        </div>
      </li>


      <li class="nav-item nav-category">Categorie</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#note" aria-expanded="false"
           aria-controls="note">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Categorie</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="note">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertCategorie">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertDetailsMateriauxCategorie">materiaux</a></li>

          </ul>
        </div>
      </li>

      <li class="nav-item nav-category">Stock</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#stock" aria-expanded="false"
           aria-controls="stock">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Stock</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="stock">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertStock">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listStock">liste</a></li>
          </ul>
        </div>
      </li>

      <li class="nav-item nav-category">prixx</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#activite" aria-expanded="false"
           aria-controls="activite">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Prix</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="activite">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/prixbase">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/benefice">benefice</a></li>
          </ul>
        </div>
      </li>

        <li class="nav-item nav-category">Ouvrier</li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#ouvrier" aria-expanded="false"
               aria-controls="ouvrier">
                <i class="menu-icon mdi mdi-card-text-outline"></i>
                <span class="menu-title">Ouvrier</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="Ouvrier">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertOuvrier">ajouter</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertEmploye">ajouterEmploye</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listEmploye">ListeEmploye</a></li>

                </ul>
            </div>
        </li>
        <li class="nav-item nav-category">Materiaux</li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#materiaux" aria-expanded="false"
               aria-controls="ouvrier">
                <i class="menu-icon mdi mdi-card-text-outline"></i>
                <span class="menu-title">Materiaux</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="materiaux">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertMateriaux">ajouter</a></li>
                </ul>
            </div>
        </li>

        <li class="nav-item nav-category">Client</li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#client" aria-expanded="false"
               aria-controls="ouvrier">
                <i class="menu-icon mdi mdi-card-text-outline"></i>
                <span class="menu-title">Client</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="Client">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertClient">ajouter</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertVente">inserer vente</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/statotal">stattotal</a></li>

                </ul>
            </div>
        </li>
        <
    </ul>
  </nav>

