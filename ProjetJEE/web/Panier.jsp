<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--pour pouvoir print en faisant <c : out> -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
        
         <!-- Bootstrap core CSS -->
        <link href="style/bootstrap.min.css" rel="stylesheet">
        <link href="style/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="style/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
    <!-- Vue Header -->
    <jsp:include page="Header.jsp" />
    <div class="container">
        <div class="col-lg-9">
            <table class="table table-striped">
                <tr>
                    <th>Article :</th><th>Description</th><th>Quantité :</th><th>Montant :</th><th>Montant Total :</th>
                </tr>
                <c:forEach items="${commande.article}" var="article">
                    <tr>
                        <td>${article.nom}</td><td>${article.description}</td><td>${article.quantité}</td><td>${article.montant} €</td><td>${article.montantTotal} €</td>
                    </tr>  
                </c:forEach>
        </table>
            <table>
                <tr>
                   <td>Montant de la commande : </td><td>${commande.montant} €</td>
                </tr>
            </table>
        <a href="<c:url value="Commandes"><c:param name="action" value="ajouter"/></c:url>">Valider la Commande</a>
        <a href="<c:url value="Panier"><c:param name="action" value="vider"/></c:url>">Vider le panier</a>
        </div> 
    </div> 
    <!-- Vue Footer -->
    <jsp:include page="Footer.jsp" />
    </body> 
</html>
