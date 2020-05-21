<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Health Clinics - Cadastro</title>
</head>
<body>
	<section id="recursos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<br> <br> <br>
					<h2>Crie sua conta</h2>
					<form action="/healthclinics/cadastro/paciente" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Nome*</label> <input
								name="nomePaciente" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Sobrenome*</label> <input
								name="sobreNome" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Endereço de e-mail *</label> <input
								name="email" type="email" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Crie uma senha *</label> <input
								name="senhaP" type="password" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Repita a senha *</label> <input
								name="senhaRepetir" type="password" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Telefone*</label> <input
								name="numeroCelular" type="text" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Data de Nascimento*</label> <input
								name="dataNasc" type="date" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">CPF*</label> <input
								name="numeroCPF" type="text" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>						
						
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">* Eu aceito <a href="temos.html"
								class="text-warning">os termos e condições</a>, e a <a
								href="privacidade" class="text-warning">política de
									privacidade</a> da Health Clinics.
							</label>
						</div>
						<br>
						<button type="submit" class="btn btn-outline-light">Criar</button>
					</form>
					

				</div>
				<div class="col-md-8">
					<div class="row rotacionar">
						<div class="col-md-6">
							<img
								src='<c:url value = "/resources/imagens/iphone1.png"></c:url>'
								class="img-fluid">
						</div>
						<div class="col-md-6">
							<img
								src='<c:url value = "/resources/imagens/iphone1.png"></c:url>'
								class="img-fluid">

						</div>
					</div>
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
