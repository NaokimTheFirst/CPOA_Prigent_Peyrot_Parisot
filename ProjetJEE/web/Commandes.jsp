<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--pour pouvoir print en faisant <c : out> -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hebergements</title>
        
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
                    <th>NomHebergement :</th><th>Type :</th><th>Catégorie:</th><th>Nb chambres :</th><th>Service :</th>
                </tr>
                <c:forEach items="${Hebergements}" var="c">
                <tr>
                    <td>${c.numhegergement}</td><td>${c.nomhebergement} €</td><td>${c.type}</td><td>${c.adresse}</td><td>${c.nbplaces}</td><td>${c.Service}</td>
                </tr>
                </c:forEach>
        </table>
        </div> 
    </div> 
    <!-- Vue Footer -->
    <jsp:include page="Footer.jsp" />
    </body> 
</html>
