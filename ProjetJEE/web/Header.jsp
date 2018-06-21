<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--pour pouvoir print en faisant <c : out> -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">
    <link href="style/bootstrap.css" rel="stylesheet">
    <link href="style/CSS1.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="style/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="Accueil.jsp">Festival de Cannes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
            <!--Affiche l'onglet "S'inscrire" et "Se connecter" si l'utilisateur n'est pas connecté-->
            <c:if test="${empty sessionScope.client}">
               
            <li class="nav-item">
                <a class="nav-link" href="Connection">Se Connecter</a>
            </li>
            <li class="nav-item"> 
                 <a class="nav-link" href="Client.jsp">S'inscrire</a>
            </li>
            </c:if>
            <!--Affiche l'onglet "Panier,"Profil" et "Se Déconnecter" si l'utilisateur est connecté-->
            <c:if test="${(not empty sessionScope.client) and (client.fonction=='Staff')}" >
                <li class="nav-item">
                  <a class="nav-link" href="SRecherche">Recherche</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="AffichageClient.jsp">Profil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Deconnection">Se déconnecter</a>
                </li>
                </ul>
            </c:if>
            <c:if test="${(not empty sessionScope.client) and (client.fonction=='Gerant')}" >
                <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="SHebergement">Mes Hebergements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AffichageClient.jsp">Profil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Deconnection">Se déconnecter</a>
                </li>
                </ul>
            </c:if>
                
          
        </div>
      </div>
    </nav>
        <!-- Bootstrap core JavaScript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
