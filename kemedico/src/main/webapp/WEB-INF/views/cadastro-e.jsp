<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
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
					<form method="POST" action="${s:mvcUrl('cad_prof_bd').build()}">
						<div class="form-group">
							<label for="exampleInputPassword1">Nome*</label> <input
								name="nomeprofsau" class="form-control" type="text"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Sobrenome*</label> <input
								name="sobrenomeprof" class="form-control" type="text"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">E-mail - Usando
								dentro da HS</label> <input type="email" class="form-control"
								name="email" id="exampleFormControlInput1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Celular</label> <input
								class="form-control" type="text" name="numeroCelular"
								placeholder="Ex: +55 (11) 99977-0000">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Especialidade</label> <select class="formControl"
								name="especialidade">
								<c:forEach items="${especialidades}" var="es">
									<option value="${es.idEsp}">${es.descEsp}</option>
								</c:forEach>
							</select>
						


						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">CRM*</label> <input
								class="form-control" type="text"
								placeholder="Preencha esse campo ele é obrigatório.">
						</div>
						<!--<div class="form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">* Eu aceito <a href="temos.html" class="text-warning">os termos e condições</a>, e a <a href="privacidade" class="text-warning">política de privacidade</a> da Doctoralia.</label>
                </div>-->
						<br>
						<button type = "submit" class="btn btn-outline-light ">Cadastrar</button>
					</form>

				</div>

			</div>
		</div>
	</section>



	<!-- JavaScript (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ include file="/WEB-INF/views/rodape.jsp"%>