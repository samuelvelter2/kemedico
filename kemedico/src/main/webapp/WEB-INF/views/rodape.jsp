<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

</head>
<body>
<br><br><br>
<footer>
      <div class="container">
        <div class="row">
          <div class="col-md-2">
            <a href="${s:mvcUrl('home').build()}" title=""><img src='<c:url value = "/resources/imagens/faviconb.png"></c:url>' width="50"></a>
          </div>
          <div class="col-md-2">
            <h4>company</h4>
            <ul class="navbar-nav">
              <li><a href="sobre.html">Sobre</a></li>
            </ul>
          </div>
          <div class="col-md-2">
            <h4>comunidades</h4>
            <ul class="navbar-nav">
              <li><a href="developer.html">Desenvolvedores</a></li>
             
            </ul>
          </div>
          <div class="col-md-2">
            <h4>links uteis</h4>
            <ul class="navbar-nav">
              <li><a href="ajuda.html">Ajuda</a></li>
            </ul>
          </div>
          <div class="col-md-4">
            <ul>
              <li>
                <a href=""><img src='<c:url value = "/resources/imagens/facebook.png"></c:url>' ></a>
              </li>
              <li>
                <a href=""><img src='<c:url value = "/resources/imagens/twitter.png"></c:url>' ></a>
              </li>
              <li>
                <a href=""><img src='<c:url value = "/resources/imagens/instagram.png"></c:url>' ></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>-->
  </body>
	
</body>
</html>