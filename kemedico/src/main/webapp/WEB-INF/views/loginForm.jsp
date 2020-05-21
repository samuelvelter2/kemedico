<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!-- HTML5Shiv -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

    <!-- Estilo customizado -->
    <link rel="stylesheet" type="text/css" href="${contextPath}resources/css/estilo.css">

    <title>Health Clinics - Login</title>
    <link rel="icon" href="${contextPath}resources/imagens/favicon.png">
  </head>
  <body>    
    

    <section id="recursos" class="caixa">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <br>
            <br>
            <br>
            <h2>Entrar</h2>
            <form>
                <div class="form-group">
                  <label for="exampleInputEmail1">Digite seu e-mail:</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Digite sua senha:</label>
                  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="">
                </div>
                <small id="emailHelp" class="form-text text-muted"><p class="text-white">Esqueceu a senha&nbsp;&nbsp;<a class="text-dark" href="">click aqui</a></p></small>
                <button type="button" class="btn btn-outline-light">Entrar</button>
            </form>

          </div>
          <div class="col-md-6">
            <div class="row">
              
              <div class="col">
                <br>
                <br>
                <br>
                <br>

                <img src="${contextPath}resources/imagens/img1-semfundo.png" width="500px" class="img-fluid">
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </section>

<!-- inicio Rodape -->
    <footer class="fixed-bottom">
      <div class="container">
        <div class="row">
          <div class="col-md-2">
            <a href="index.html" title=""><img src="${contextPath}resources/imagens/h1.png" width="50"></a>
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
                <a href=""><img src="${contextPath}resources/imagens/facebook.png"></a>
              </li>
              <li>
                <a href=""><img src="${contextPath}resources/imagens/twitter.png"></a>
              </li>
              <li>
                <a href=""><img src="${contextPath}resources/imagens/instagram.png"></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>