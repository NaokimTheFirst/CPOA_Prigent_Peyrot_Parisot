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
        <link href="style/CSS1.css" rel="stylesheet">
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
                    <th>NomHebergement :</th><th>Type :</th><th>Adresse :</th><th>Service :</th>
                </tr>
                <c:forEach items="${hebergements}" var="c">
                <tr>
                    <td>${c.nomhebergement}</td><td>${c.type}</td><td>${c.adresse}</td><td>${c.services}</td>
                </tr>
                </c:forEach>
                
            </table>
            <form method="post" action="SHebergement">
                <fieldset>
                    <h4>Informations Hebergements</h4>
                    <table>
                    <tr>
                      <th><label for="nomH">Nom Hebergement</label></th>
                      <td><input type="text"  name="nomH" size="20" maxlength="20" required/></td>
                    </tr>
                    <tr>
                      <th><label for="type">Type : </label></th>
                      <td><input type="text"  name="type"  size="20" maxlength="20" required/></td>
                    </tr>
                    <tr>
                      <th><label for="type">Adresse : </label></th>
                      <td><input type="text"  name="adresse"  size="20" maxlength="20" required/></td>
                    </tr>
                    <tr>
                      <th><label for="type">Services : </label></th>
                      <td><input type="text"  name="services"  size="20" maxlength="20" required/></td>
                    </tr>
                    </table>
                </fieldset>
                
            
            <div class="month">      
            <ul>
              <li class="prev">&#10094;</li>
              <li class="next">&#10095;</li>
              <li>
                August<br>
                <span style="font-size:18px">2017</span>
              </li>
            </ul>
          </div>

          <ul class="weekdays">
            <li>Mo</li>
            <li>Tu</li>
            <li>We</li>
            <li>Th</li>
            <li>Fr</li>
            <li>Sa</li>
            <li>Su</li>
          </ul>

          <ul class="days">  
            <li>1<input type="text"  name="d1" size="5" maxlength="5" /></li>
            <li>2<input type="text"  name="d2" size="5" maxlength="5" /></li>
            <li>3<input type="text"  name="d3" size="5" maxlength="5" /></li>
            <li>4<input type="text"  name="d4" size="5" maxlength="5" /></li>
            <li>5<input type="text"  name="d5" size="5" maxlength="5" /></li>
            <li>6<input type="text"  name="d6" size="5" maxlength="5" /></li>
            <li>7<input type="text"  name="d7" size="5" maxlength="5" /></li>
            <li>8<input type="text"  name="d8" size="5" maxlength="5" /></li>
            <li>9<input type="text"  name="d9" size="5" maxlength="5" /></li>
            <li>10<input type="text"  name="d10" size="5" maxlength="5" /></li>
            <li>11<input type="text"  name="d11" size="5" maxlength="5" /></li>
            <li>12<input type="text"  name="d12" size="5" maxlength="5" /></li>
            <li>13<input type="text"  name="d13" size="5" maxlength="5" /></li>
            <li>14<input type="text"  name="d14" size="5" maxlength="5" /></li>
            <li>15<input type="text"  name="d15" size="5" maxlength="5" /></li>
            <li>16<input type="text"  name="d16" size="5" maxlength="5" /></li>
            <li>17<input type="text"  name="d17" size="5" maxlength="5" /></li>
            <li>18<input type="text"  name="d18" size="5" maxlength="5" /></li>
            <li>19<input type="text"  name="d19" size="5" maxlength="5" /></li>
            <li>20<input type="text"  name="d20" size="5" maxlength="5" /></li>
            <li>21<input type="text"  name="d21" size="5" maxlength="5" /></li>
            <li>22<input type="text"  name="d22" size="5" maxlength="5" /></li>
            <li>23<input type="text"  name="d23" size="5" maxlength="5" /></li>
            <li>24<input type="text"  name="d24" size="5" maxlength="5" /></li>
            <li>25<input type="text"  name="d25" size="5" maxlength="5" /></li>
            <li>26<input type="text"  name="d26" size="5" maxlength="5" /></li>
            <li>27<input type="text"  name="d27" size="5" maxlength="5" /></li>
            <li>28<input type="text"  name="d28" size="5" maxlength="5" /></li>
            <li>29<input type="text"  name="d29" size="5" maxlength="5" /></li>
            <li>30<input type="text"  name="d30" size="5" maxlength="5" /></li>
          </ul>
        <input type="submit" value="Valider"/>
        <input type="reset" value="Remettre à zéro" /> 
    </form>
        </div>
    </div>
    <!-- Vue Footer -->
    <jsp:include page="Footer.jsp" />
    </body> 
</html>
