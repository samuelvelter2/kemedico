<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>


<title>Health Clinics</title>

</head>
<body>



	<section id="servicos" class="caixa">
		<div class="container text-center ">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 ">
					<br> <br> <img src='<c:url value = "/resources/imagens/lg-kemedico.png"></c:url>'
						width="600px">
				</div>
			</div>
			<div class="col-md-2"></div>
			<form>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="exampleFormControlSelect1">Qual especialista
							você procura ?</label> <select class="form-control"
							id="exampleFormControlSelect1">
							<option></option>
							<option>Anestesiologista</option>
							<option>Clínica médica</option>
							<option>Dermatologista</option>
							<option>Cardiologista</option>
							<option>Pscicólogo</option>
							<option>Ginecologista</option>
							<option>Homeopatia</option>
							<option>Pediatra</option>
							<option>Endocrinologista</option>
							<option>Infectologista</option>
							<option>Dentista</option>
							<option>Neurocirurgista</option>
							<option>Oncologista</option>
							<option>Nutrologista</option>
							<option>Geriatra</option>
							<option>Neurologista</option>
							<option>Oftalmologista</option>
							<option>Ortopedista</option>
							<option>Otorrinolaringologista</option>
							<option>Fisioterapeuta</option>
						</select>
					</div>

					<div class="form-group col-md-6">
						<label for="validationTextarea">Cidade-UF: *</label> <select
							class="custom-select" required>
							<option class="text-center"></option>
							<option>Acre(AC)</option>
							<option>Alagoas (AL)</option>
							<option>Amapá (AP)</option>
							<option>Amazonas (AM)</option>
							<option>Bahia (BA)</option>
							<option>Ceará (CE)</option>
							<option>Distrito Federal (DF)</option>
							<option>Espírito Santo (ES)</option>
							<option>Goiás (GO)</option>
							<option>Maranhão (MA)</option>
							<option>Mato Grosso (MT)</option>
							<option>Mato Grosso do Sul (MS)</option>
							<option>Minas Gerais (MG)</option>
							<option>Pará (PA)</option>
							<option>Paraíba (PB)</option>
							<option>Paraná (PR)</option>
							<option>Pernambuco (PE)</option>
							<option>Piauí (PI)</option>
							<option>Rio de Janeiro (RJ)</option>
							<option>Rio Grande do Norte (RN)</option>
							<option>Rio Grande do Sul (RS)</option>
							<option>Rondônia (RO)</option>
							<option>Roraima (RR)</option>
							<option>Santa Catarina (SC)</option>
							<option>São Paulo (SP)</option>
							<option>Sergipe (SE)</option>
							<option>Tocantins (TO)</option>

						</select>
					</div>
				</div>


				<div class="form-row col-md-12  text-center">
					<fieldset class="form-group">
						<div class="row ">
							<legend class="col-form-label col-sm-5 text-center ">Possue
								algum convenio de saúde?</legend>

							<div class="col-sm-5text-center">
								<div class="input-group">
									<span class="input-group-addon"> <label
										class="radio-inline" for="radios-0"> <input
											type="radio" name="convenio" id="convenio" value="nao"
											onclick="desabilita('convenio_qtd')" required> Não
									</label> <label class="radio-inline p-2 text-center" for="radios-1">
											<input type="radio" name="convenio" id="convenio" value="sim"
											onclick="habilita('convenio_qtd')"> Sim
									</label> <label class="radio-inline p-2 text-center" for="radios-2">
											<input type="radio" name="convenio" id="convenio"
											value="outro" onclick="desabilita('convenio_qtd')">
											Outro
									</label>
									</span> <select id="convenio_qtd" name="convenio_qtd" class="col-sm-6"
										type="text" placeholder="Qual?" pattern="[0-9]+$">
										<option selected></option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
					</fieldset>



				</div>

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Pesquisar</button>
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Aviso!</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								Para pesquisar mais sobre os especialistas cadastre-se! <br>É
								gratuito.
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Fechar</button>
								<button type="button" class="btn btn-primary">
									<a href="cadastro.html" class="text-white">Cadastrar</a>
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>

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

							<div class="carousel-item active">
								<h1>Saúde para todos</h1>
							</div>

							<div class="carousel-item">
								<h1>Os melhores especialistas</h1>
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

					<img src="imagens/estrela.png" class="rounded" width="150px">

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
