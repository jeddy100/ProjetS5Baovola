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
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listVoyage">liste</a></li>
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
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listBouquet">liste</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertDetailsMateriauxCategorie">materiaux</a></li>

          </ul>
        </div>
      </li>

      <li class="nav-item nav-category">prixx</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#activite" aria-expanded="false"
           aria-controls="activite">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Activités</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="activite">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/prixbase">ajouter</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/listActivite">liste</a></li>
          </ul>
        </div>
      </li>
    </ul>
  </nav>

