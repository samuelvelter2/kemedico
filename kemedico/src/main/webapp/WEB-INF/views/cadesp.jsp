<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />
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
<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>

<title>Health Clinics - Cadastro E</title>
</head>
<body>
	<section id="recursos" class="caixa">
		<div class="container">

			<div class="row">
				<div class="col-md-8">
					<br> <br> <br> <br>
					<div class="row">

						<div class="col-md-12">
							<div class="jumbotron " style="background-color: #007bff">
								<h1 class="display-2 text-warning">Especialista!</h1>
								<p class="lead">As melhores ferramentas para profissionais
									de saúde</p>
								<hr class="my-4">
								<p class="lead">
									<a href="premium.html" class="btn btn-outline-light ">Benefícios</a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<br> <br> <br>
					<h2>Crie sua conta Gratuita*</h2>
					<form method="POST" action="${s:mvcUrl('cad_esp_bd').build()}">
						<div class="form-group">
							<label for="exampleInputPassword1">Nome*</label> <input
								name="descEsp" class="form-control" type="text" placeholder="">
						</div>						
						<button type="submit" class="btn btn-outline-light ">Cadastrar</button>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
