<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--pour pouvoir print en faisant <c : out> -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
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
            <!-- action : Lien vers la serlvet en chage d'afficher le client créé-->
            <form method="post" action="Connection">
                <h4>Informations </h4>
                <fieldset>
                    <table>
                    <tr>
                      <th><label for="nomClient">Nom</label></th>
                      <td><input type="text" id="nomClient" name="nomClient" value="${nom}" size="20" maxlength="20" required/></td>
                    </tr>
                    <tr>
                      <th><label for="prenomClient">Prénom </label></th>
                      <td><input type="text" id="prenomClient" name="prenomClient" value="${prenom}" size="20" maxlength="20" required/></td>
                    </tr>
                    <tr>
                        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
                        <th><p class="bg-warning">${ message }</p></th>
                    </tr>
               </table>
                <label for="memoire">Se souvenir de moi</label>
                <input type="checkbox" id="memoire" name="memoire" />
                </fieldset>
                <input type="submit" value="Se Connecter"/>
               <input type="reset" value="Remettre à zéro"/>
            </form>
            <br/>
        </div>
    </div>
    <!-- Vue Footer -->
    <jsp:include page="Footer.jsp" />
    </body>
</html>