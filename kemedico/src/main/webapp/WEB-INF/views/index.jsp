<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>


<title>Kemédico - Nós temos médicos</title>

<script>
	$(document).ready(function() {
		$("#select-especialidade").select2({

		});
		$("#select-cidade").select2({

		});
		$("#select-plano").select2({

		});

	});
</script>

</head>
<body>
	<section id="servicos" class="caixa">
		<div class="container text-center ">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 ">
					<br> <br> <img
						src='<c:url value = "/resources/imagens/lg-kemedico.png"></c:url>'
						width="600px">
				</div>
			</div>
			<div class="col-md-2"></div>
			<form:form servletRelativeAction="${s:mvcUrl('pesquisar').build()}"
				modelAttribute="pesquisa" method="get">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="exampleFormControlSelect1">Qual especialista
							você procura ?</label>
						<form:select id="select-especialidade" path="especialidade.idEsp"
							class="custom-select" name="especialidade" required="required">
							<form:options class="text-center" items="${especialidades}"
								itemValue="idEsp" itemLabel="descEsp" />
						</form:select>
					</div>

					<div class="form-group col-md-6">
						<label for="validationTextarea">Cidade-UF: *</label>
						<form:select id="select-cidade" path="cidade.idCidade"
							class="custom-select" name="cidade" required="required">
							<form:options class="text-center" items="${cidades}"
								itemValue="idCidade" itemLabel="nomeComUF" />
						</form:select>


					</div>

				</div>


				<div class="form-row col-md-12  text-center">
					<fieldset class="form-group">
						<div class="row  ">
							<legend class="col-form-label col-sm-5 text-center ">Possue
								algum convenio de saúde?</legend>
							<div class="form-check  col-md-4  float-right ">

								<input type="radio" class="form-check-input" id="exampleCheck1"
									name="tipoPesquisa" checked="checked" value="med"> <label
									class="form-check-label pr-5 text-center  " for="exampleCheck1">Médicos</label>

								<input type="radio" class="form-check-input" id="exampleCheck2"
									name="tipoPesquisa" value="cli"> <label
									class="form-check-label p-1 " for="exampleCheck2">Clínicas</label>

							</div>
							<div class="col-sm-5 text-center">
								<div class="input-group">
									<span class="input-group-addon"> <label
										class="radio-inline" for="radios-0"> <input
											type="radio" name="convenio" id="convenio" value="false"
											onclick='desabilita("select-plano")' required> Não
									</label> <label class="radio-inline p-2 text-center" for="radios-1">
											<input type="radio" name="convenio" id="convenio"
											value="true" onclick='habilita("select-plano")'
											checked="checked"> Sim
									</label>

									</span>
								</div>
								<form:select id="select-plano" path="planos"
									class="custom-select" name="planos" required="required"
									itemLabel="selecione pelo menos um">
									<form:options items="${planos}" itemValue="id"
										itemLabel="nomePlano" />
								</form:select>
							</div>
						</div>
					</fieldset>



				</div>



				<button type="submit" class="btn btn-primary">Pesquisar</button>


			</form:form>

		</div>
	</section>

	<section id="home" class="d-flex">
		<!--home -->
		<div class="container align-self-center">
			<!--container -->
			<div class="row">
				<!--row -->
				<div class="col-md-12 capa">

					<div id="carousel-spotify" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<!--Inner -->
							<div class="carousel-item">
								<h1>Os melhores especialistas</h1>
							</div>

							<div class="carousel-item active">
								<h1>Dentro de apenas uma plataforma</h1>
							</div>

							<div class="carousel-item">
								<h1>Kémédico</h1>
							</div>

						</div>
						<!--/Inner -->

						<!-- Controles -->
						<a href="#carousel-spotify" class="carousel-control-prev"
							data-slide="prev"> <i class="fas fa-angle-left fa-3x"></i>
						</a> <a href="#carousel-spotify" class="carousel-control-next"
							data-slide="next"> <i class="fas fa-angle-right fa-3x"></i>
						</a>

					</div>

				</div>
			</div>
			<!--/row -->
		</div>
		<!--/container -->
	</section>
	<!--/home -->

	<section id="recursos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">

					<h2>Fácil</h2>
					<br>
					<h3>Buscar</h3>
					<p>Coloque a especialidade que deseja e o estado que se
						encontra no momento e o resto é com a gente.</p>
					<br>
					<h3>Avalie o serviço</h3>
					<p>Após a consulta você poderá deixar sua opinião sobre o
						especialista.Para que outras pessoas vejam.Tudo isso de forma
						pratica e rápida, simples e rápida.</p>

					<img src='<c:url value = "/resources/imagens/estrela.png"></c:url>'
						class="rounded" width="150px">

				</div>
			</div>

		</div>
	</section>

	<!-- JavaScript (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<!--  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>-->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>


</body>
</html>
<%@ include file="/WEB-INF/views/rodape.jsp"%>
