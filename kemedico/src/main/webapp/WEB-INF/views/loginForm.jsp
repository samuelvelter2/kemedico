<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/bootstrap/css/bootstrap.min.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/animate/animate.css"></c:url>'>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/css-hamburgers/hamburgers.min.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/animsition/css/animsition.min.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/select2/select2.min.css"></c:url>'>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/vendor/daterangepicker/daterangepicker.css"></c:url>'>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/css/util.css"></c:url>'>
	<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/css/login.css"></c:url>'>
<!--===============================================================================================-->
</head>
<body>
  <header><!-- inicio Cabecalho -->
    <nav class="navbar navbar-expand-md navbar-light fixed-top navbar-transparente">
      <div class="container">
        
        <a href="index.html" class="navbar-brand">
          <img src='<c:url value = "/resources/imagens/faviconb.png"></c:url>' width="50">
        </a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#nav-principal">
          <i class="fas fa-bars text-white"></i>
        </button>

        <div class="collapse navbar-collapse" id="nav-principal">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a href="" class="nav-link"></a>
            </li>
            
            
            
          </ul>
        </div>

      </div>
    </nav>
  </header><!--/fim Cabecalho -->
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form:form servletRelativeAction="/login" method="POST" class="login100-form validate-form">
					<span class="login100-form-title p-b-33">
						Entrar
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Requer um email válido">
						<input class="input100" type="text" name="username" placeholder="Email">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Requer uma senha">
						<input class="input100" type="password" name="password" placeholder="Senha">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button type="submit" class="login100-form-btn">
							Entrar
						</button>
					</div>

					<div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							Esqueceu sua
						</span>

						<a href="#" class="txt2 hov1">
							senha?
						</a>
					</div>

					<div class="text-center">
						<span class="txt1">
							Criar uma conta?
						</span>

						<a href="cadastro.html" class="txt2 hov1">
							Inscrever-se
						</a>
					</div>
				</form:form>
			</div>
		</div>
  </div>
  
	

	
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/jquery/jquery-3.2.1.min.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/animsition/js/animsition.min.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/bootstrap/js/popper.js"></c:url>'></script>
	<script src='<c:url value = "/resources/vendor/bootstrap/js/bootstrap.min.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/select2/select2.min.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/daterangepicker/moment.min.js"></c:url>'></script>
	<script src='<c:url value = "/resources/vendor/daterangepicker/daterangepicker.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/vendor/countdowntime/countdowntime.js"></c:url>'></script>
<!--===============================================================================================-->
	<script src='<c:url value = "/resources/js/main.js"></c:url>'></script>

</body>
</html>