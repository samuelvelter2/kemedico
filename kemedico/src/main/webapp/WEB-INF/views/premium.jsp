<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>

<title>Kémédico - Planos e Preços</title>
</head>
<body>
	<section id="recursos" class="caixa">
		<div class="container">

			<div class="row">
				<div class="col-md-8">

					<br>
					<div class="row">

						<div class="col-md-12">
							<div class="jumbotron " style="background-color: #007bff">
								<p class="lead">Um dos melhores sites para profissionais da
									área da saúde que buscam rapidez e eficiência</p>
								<hr class="my-4">
								<h2>Crie sua conta Gratuita</h2>
								<a href="cadastro.html" class="btn btn-outline-light ">Cadastrar</a>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

	<section id="servicos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="row albuns"></div>
				</div>
				<div class="col-md-12">

					<h3>Benefícios!</h3>
					<!-- Tabela inicio -->
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Plano</th>
								<th scope="col">Gratuito</th>
								<th scope="col" style="color: #daa520">Premium</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<th scope="row">Perfil Visível</th>
								<td><i class="fas fa-check-circle"></i></td>
								<td><i class="fas fa-check-circle"></i></td>
							</tr>

							<tr>
								<th scope="row">Informações no Perfil</th>
								<td><i class="fas fa-times-circle"></i></td>
								<td><i class="fas fa-check-circle"></i></td>
							</tr>



							<tr>
								<th scope="row">Mensalidade</th>
								<td><p>
										R$ 0,00/Por mês<br> <a href="${s:mvcUrl('cadastro').build()}"
											type="button" class="btn btn-outline-primary">Cadastrar</a>
									</p></td>
								<td><p>
										R$ 10,00/Por mês<br> <a href="${s:mvcUrl('cadastro').build()}"
											type="button" class="btn btn-outline-primary">Cadastrar</a>
									</p></td>
							</tr>
						</tbody>
					</table>
					<!-- Tabela fim -->



				</div>
			</div>
		</div>
	</section>
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
	<%@ include file="/WEB-INF/views/rodape.jsp"%>
</body>
</html>