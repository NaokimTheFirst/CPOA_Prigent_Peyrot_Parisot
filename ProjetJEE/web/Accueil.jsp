<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--pour pouvoir print en faisant <c : out> -->
<!DOCTYPE html>
<html lang="fr">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>La Halle aux Chaussettes</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">
    <link href="style/bootstrap.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="style/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <jsp:include page="Header.jsp" />

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

<!--          <div id="myCarousel" class="carousel slide" data-ride="carousel">
   Indicators 
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

   Wrapper for slides 
  <div class="carousel-inner">
    <div class="item active">
      <img src="Images/Caroussel1.jpg" alt="Los Angeles">
    </div>

    <div class="item">
      <img src="Images/Caroussel2.jpg" alt="Chicago">
    </div>

    <div class="item">
      <img src="Images/Caroussel3.jpg" alt="New York">
    </div>
  </div>

   Left and right controls 
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>-->

          <div class="row">

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette1.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes à poids</a>
                  </h4>
                  <h5>$24.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                     <a href="<c:url value="Panier"><c:param name="article" value="1"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette2.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes unicolore</a>
                  </h4>
                  <h5>$19.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                    <a href="<c:url value="Panier"><c:param name="article" value="2"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette3.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes à motif</a>
                  </h4>
                  <h5>$19.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                    <a href="<c:url value="Panier"><c:param name="article" value="3"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette4.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes sports</a>
                  </h4>
                  <h5>$29.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                    <a href="<c:url value="Panier"><c:param name="article" value="4"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette5.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes fantaisies</a>
                  </h4>
                  <h5>$24.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                    <a href="<c:url value="Panier"><c:param name="article" value="5"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="Images/Chaussette6.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Chaussettes à carreaux</a>
                  </h4>
                  <h5>$19.99</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                  <!--Affiche le bouton "Ajouter au Panier" si l'utilisateur est connecté-->
                  <c:if test="${not empty sessionScope.client}">
                    <a href="<c:url value="Panier"><c:param name="article" value="6"/></c:url>">Ajouter au panier</a>
                  </c:if>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <jsp:include page="Footer.jsp" />

    <!-- Bootstrap core JavaScript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    
  </body>

</html>
