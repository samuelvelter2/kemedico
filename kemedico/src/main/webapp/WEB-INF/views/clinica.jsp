<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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

<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>

<!-- HTML5Shiv -->
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<![endif]-->




<title>Kémédico - Médico</title>
</head>
<body>

	<section id="servicos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-12 bg-white">
					<br> <br> <br> <br> <br>



					<table class="table">
						<thead class="thead-white">
							<tr>
								<th scope="col"><img class="align-items-center"
									style="border: 2px solid #007bff"
									src="${s:mvcUrl('foto').arg(0, clinica.fotoPerfil.idFoto).build()}"
									class="img-fluid" width="200px">
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Nome:</th>
								<td>${clinica.nomeCompleto}</td>

							</tr>
							<tr>
								<th scope="row">Especializações</th>
								<td><c:forEach items="${clinica.especialidades}" var="esp">
										<span class="badge badge-secondary" style="font-size: 17px">${esp.descEsp}</span>
									</c:forEach></td>

							</tr>

							<tr>
								<th scope="row">Telefone:</th>
								<td>${clinica.numeroFixo}</td>

							</tr>
							<c:if test="${clinica.premium}">
								<tr>
									<th scope="row">Endereço:</th>
									<td>${clinica.rua},${clinica.numero} ,
										${clinica.bairro.nomeBairro} , ${clinica.cidade.nomeComUF}</td>

								</tr>
								<tr>
									<th scope="row">Email:</th>
									<td>${clinica.email}</td>

								</tr>
								<tr>
									<th scope="row">Formas de Pagamento:</th>
									<td><c:forEach items="${clinica.meiosPagamento}"
											var="meio">
											<span class="badge badge-secondary" style="font-size: 17px">${meio.descMeio}</span>
										</c:forEach></td>

								</tr>
								<tr>
									<th scope="row">Valor Consulta:</th>
									<td>${clinica.cifroes.faixaPrecos}
									<td>
								</tr>
							</c:if>

						</tbody>
					</table>

				</div>


			</div>

		</div>

	</section>
	<section id="home" class="d-flex">
		<div class="container">

			<div class="row">
				<div class="col-md-8">

					<br>
					<div class="row">

						<div class="col-md-12">
							<div class="jumbotron " style="background-color: white">
								<sec:authorize access="isAuthenticated()">
									<h2 class="m-3">Avalie:</h2>
									<p>1 - Muito Ruim | 2 -Ruim | 3 - Regular | 4 - Bom | 5 -
										Muito Bom</p>
									<hr class="my-4">
									<div class="form-row">
										<div class="col-md-5">
											<form:form
												servletRelativeAction="${s:mvcUrl('av_cli').build()}">
												<input name="clinica.id" value="${clinica.id }"
													hidden="true">
												<div class="estrelas text-center col-md-12">
													<label for="validationDefault01">Quão satisfeito
														está com esse especialista?</label> <label for="cm_star-1">1<i
														class="fa"></i></label> <input type="radio" id="cm_star-1"
														name="estrelas" value="1"> <label for="cm_star-2">2<i
														class="fa"></i></label> <input type="radio" id="cm_star-2"
														name="estrelas" value="2"> <label for="cm_star-3">3<i
														class="fa"></i></label> <input type="radio" id="cm_star-3"
														name="estrelas" value="3"> <label for="cm_star-4">4<i
														class="fa"></i></label> <input type="radio" id="cm_star-4"
														name="estrelas" value="4"> <label for="cm_star-5">5<i
														class="fa"></i></label> <input type="radio" id="cm_star-5"
														name="estrelas" value="5">
												</div>
												<label for="validationDefault01">Comentário</label>
												<input id="comentario" name="comentario"
													placeholder="Ex.:Gostei dele, muito gentil"
													class="form-control input-md" type="text" required>

												<button type="submit"
													class="btn btn-outline-primary  col-md-12">Avaliar</button>
											</form:form>
										</div>


									</div>
								</sec:authorize>
								<sec:authorize access="!isAuthenticated()">
								<b>É necessário estar logado para avaliar!</b>
								</sec:authorize>


								<h2 class="m-3">Avaliações:</h2>
								<c:forEach items="${avaliacoes}" var="avalia">
									<b>${avalia.paciente.apelido.toString()}</b>
									<p>${avalia.estrelas}<i class="fa fa-star" style="color: #FFD700; font-size: 25px"></i></p>
							<p>${avalia.comentario}</p>
								</c:forEach>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/rodape.jsp"%>
</body>
</html>