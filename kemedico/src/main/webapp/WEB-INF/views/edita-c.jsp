<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-theme/0.1.0-beta.10/select2-bootstrap.css">

<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.full.js"></script>
<script>
	$(document).ready(function() {
		$("#select-especialidades").select2({

		});
		$("#select-plano").select2({

		});
		$("#select-meios").select2({

		});
	});
</script>
<script src='<c:url value = "/resources/js/cep.js"></c:url>'></script>
<title>Health Clinics - Editando Hospital/Clinca</title>
</head>
<body>
	

					


	<section id="recursos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<br> <br> <br>
					<h2>Editar Hospital/Clínica</h2>					
				<img class="align-items-center"
						src="${s:mvcUrl('foto').arg(0,cli.fotoPerfil.idFoto).build()}"
						class="img-fluid" width="200px">
						<br> <br> 
					<form:form class="was-validated"
						servletRelativeAction="${s:mvcUrl('update_cli').build()}"
						modelAttribute="cli" enctype="multipart/form-data">
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<input value="${cli.id }" name="id" hidden="true"> <label
									for="validationDefault01">Nome Hospital/Clínica*:</label> <input
									type="text" class="form-control" id="validationDefault01"
									placeholder="Ex.:Hospital de Base" value="${cli.nomeCompleto}"
									required="required" name="nomeCompleto" />
							</div>
							<div class="col-md-2 mb-3">
								<label for="validationDefault02">Email*:</label> <input
									class="form-control input-text" id="validationDefault02"
									placeholder="email@email.com" value="${cli.email}" type="email"
									required="required" name="email"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" />
							</div>
							<div class="col-md-2 mb-3">
								<label for="validationDefault03">CNPJ*:</label> <input
									type="text" class="form-control" id="validationDefault03"
									placeholder=" xx.xxx.xxx/xxxx-xx" required="required"
									name="cnpj" maxlength="14" pattern="[0-9\s]+$"
									value="${cli.cnpj}" />
							</div>
							<div class="col-md-2 mb-3">
								<label for="validationDefault04">Telefone Fixo*:</label> <input
									type="text" class="form-control" id="validationDefault04"
									placeholder="(xx) xxxx-xxxx" required="required"
									name="numeroFixo" maxlength="11" pattern="[0-9\s]+$"
									value="${cli.numeroFixo}" />
							</div>
							<div class="col-md-2 mb-3">
								<label for="validationDefault05">Telefone Celular*:</label> <input
									type="text" class="form-control" id="validationDefault05"
									placeholder="(xx) xxxx-xxxx" required="required"
									name="numeroCelular" maxlength="10" pattern="[0-9\s]+$"
									value="${cli.numeroCelular}">
							</div>
						</div>
						<hr class="my-4">



						<div class="form-row">

							<div class="col-md-2 mb-3">
								<label for="validationServer03">CEP*:</label> <input type="text"
									class="form-control is-invalid" id="cep" placeholder=""
									name="CEP" required value="${cli.CEP}">

							</div>
							<div class="col-md-3 mb-3">
								<label for="validationServer04">Rua*:</label> <input type="text"
									class="form-control is-invalid" id="rua" placeholder="" name = "rua"
									required value="${cli.rua}">

							</div>
							<div class="col-md-2 mb-3">
								<label for="validationServer05">Bairro*:</label> <input
									type="text" class="form-control is-invalid" id="bairro" name = "bairro1"
									placeholder="" required value="${cli.bairro.nomeBairro}">

							</div>
							<div class="col-md-2 mb-3">
								<label for="validationServer05">Cidade*:</label> <input
									type="text" class="form-control is-invalid" id="cidade" name= "cidade1"
									placeholder="" required value="${cli.cidade.nomeCidade}">

							</div>
							<div class="col-md-2 mb-3">
								<label for="validationServer05">UF*:</label> <input type="text"
									class="form-control is-invalid" id="uf" placeholder="Ex:DF" name = "uf1"
									required value="${cli.cidade.ufCidade.sgUF}">

							</div>
							<div class="col-md-3 mb-3">
								<label for="validationServer05">Numero*:</label> <input
									type="text" class="form-control is-invalid" id="numeroLocal"
									placeholder="" name="numeroLocal" required
									value="${cli.numeroLocal}">

							</div>
							<div class="col-md-3 mb-3">
								<label for="validationServer05">Complemento*:</label> <input
									type="text" class="form-control is-invalid" id="complemento"
									placeholder="" name="complemento" required
									value="${cli.complemento}">

							</div>

							<div class="col-lg-3 mb-4">
								<label for="validationTextarea" id="ck">Especialidades
									da clinica:*</label>
								<form:select id="select-especialidades" path="especialidades"
									class="custom-select" name="especialidades" required="required"
									multiple="true" itemLabel="selecione pelo menos um">
									<option class="text-center"></option>
									<c:forEach items="${prof.especialidades}" var="esp">
										<option value="${esp.idEsp}" label="${esp.descEsp}"
											selected="selected"></option>
									</c:forEach>
									<form:options items="${especialidades}" itemValue="idEsp"
										itemLabel="descEsp" />
								</form:select>
							</div>
							<div class="col-lg-3 mb-4">
								<label for="validationTextarea" id="ck">Planos de Saúde
									Aceitos(opcional):</label>
								<form:select id="select-plano" path="planos"
									class="custom-select" name="planos" multiple="true"
									itemLabel="selecione pelo menos um">
									<c:forEach items="${prof.planosParticular }" var="plano">
										<option value="${plano.id }" label="${plano.nomePlano}"
											selected="selected"></option>
									</c:forEach>
									<form:options items="${planos}" itemValue="id"
										itemLabel="nomePlano" />
								</form:select>
							</div>
							<div class="col-lg-3 mb-4">
								<label for="validationTextarea" id="ck">Meios de
									Pagamento(opcional):</label>
								<form:select id="select-meios" path="meiosPagamento"
									class="custom-select" name="planos" multiple="true"
									itemLabel="selecione pelo menos um">
									<c:forEach items="${prof.meiosPagamento}" var="meio">
										<option value="${meio.idMeio}" label="${meio.descMeio}"
											selected="selected"></option>
									</c:forEach>
									<form:options items="${meios}" itemValue="idMeio"
										itemLabel="descMeio" />
								</form:select>
							</div>
							<div class="col-md-2 mb-3">

							<div class="form-group">
								<label for="validationTextarea">Preço da consulta *: </label>
								<form:select class="custom-select" required="required"
									name="cifroes" path="cifroes.cifroes">
									<option value="${cli.cifroes.cifroes}" selected="selected"
										class="text-center"></option>
										<form:options items="${cifroes}" itemLabel="faixaPrecos" itemValue="cifroes"/>

								</form:select>
							</div>
						</div>
							<hr class="col-md-12 ">
							<div class="custom-file col-md-3 ">
								<input name="fotoPerfilP" type="file" class="custom-file-input"
									id="exampleInputPassword1" accept="image/*"> <label
									for="exampleFileLang " for="validationDefault05"
									class="custom-file-label">Escolha uma foto de perfil</label>

							</div>
							<hr class="col-md-12 ">
							<div class="custom-file col-md-3 ">
								<button type="submit" class="btn btn-outline-light">Salvar</button>								
							</div>
							<div class="custom-file col-md-3 ">
								<button type="submit" class="btn btn-danger">Excluir</button>								
							</div>



						</div>

					</form:form>

				</div>
			</div>
		</div>

	</section>



	<!-- JavaScript (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>-->
</body>
</html>

<%@ include file="/WEB-INF/views/rodape.jsp"%>