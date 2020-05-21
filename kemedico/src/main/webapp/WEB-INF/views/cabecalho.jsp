<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!-- HTML5Shiv -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

<!-- Estilo customizado -->
<link rel="stylesheet" type="text/css" href='<c:url value = "/resources/css/estilo.css"></c:url>'>

<link rel="icon" href='<c:url value = "/resources/imagens/favicon.png"></c:url>'>
</head>
<body>

	<header>
		<!-- inicio Cabecalho -->
		<nav
			class="navbar navbar-expand-md navbar-light fixed-top navbar-transparente">
			<div class="container">

				<a href="${s:mvcUrl('home').build()}" class="navbar-brand"> <img
					src='<c:url value = "/resources/imagens/h1.png"></c:url>' width="50">
				</a>

				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#nav-principal">
					<i class="fas fa-bars text-white"></i>
				</button>

				<div class="collapse navbar-collapse" id="nav-principal">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="" class="nav-link"></a></li>
						<li class="nav-item"><a href="agendar.html" class="nav-link">Agendar</a>
						</li>
						<li class="nav-item"><a href="premium.html" class="nav-link">Benefícios</a>
						</li>

						<li class="nav-item divisor"></li>

						<li class="nav-item"><a href="/healthclinics/cadastro"
							class="nav-link">Inscrever-se</a></li>
						<li class="nav-item"><a href="/healthclinics/login"
							class="nav-link">Entrar</a></li>
					</ul>
				</div>

			</div>
		</nav>
	</header>
	<!--/fim Cabecalho -->
</body>
</html>
