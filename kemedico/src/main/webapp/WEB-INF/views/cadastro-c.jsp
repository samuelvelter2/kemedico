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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-theme/0.1.0-beta.10/select2-bootstrap.css">

<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.full.js"></script>
<script>
$(document).ready(function() {
    $("#form-dropdown").select2({
        
    });
});
</script>
<script src='<c:url value = "/resources/js/cep.js"></c:url>'></script>
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
					<form:form method="POST" action="${s:mvcUrl('cad_cli_bd').build()}"
						modelAttribute="clinica">
						<div class="form-group">
							<label for="exampleInputEmail1">Nome</label> <input
								name="nomeClinica" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">CNPJ</label> <input name="cnpj"
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Telefone*</label> <input
								name="numeroLocal" type="text" class="form-control"
								id="exampleInputPassword1" placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">CPF do Responsavel*</label> <input
								name="cpfResp" type="text" class="form-control"
								id="exampleInputPassword1" placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">CEP do Local*</label> <input
								name="cep" type="text" class="form-control" id="cep"
								placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Rua:*</label> <input
								name="rua" type="text" class="form-control" id="rua"
								placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Bairro:*</label> <input
								name="bairro" type="text" class="form-control" id="bairro"
								placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Cidade:*</label> <input
								name="cidade" type="text" class="form-control" id="cidade"
								placeholder="">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">UF:*</label> <input name="uf"
								type="text" class="form-control" id="uf" placeholder="">

						</div>
						<input name="ibge" type="text" class="form-control" id="ibge"
							placeholder="" hidden="true">
						<div class="form-group">
							<label for="exampleInputPassword1">Planos de Saude:*</label>
							<form:select multiple="true" path="planos" class="form-control input-sm select2-multiple" style = "width: 50%" id="form-dropdown">
								<form:options items="${planosSaude}" itemValue="id"
									itemLabel="nomePlano" />
							</form:select>
						</div>
						<!--  <div class="form-group">
							<label for="exampleFormControlSelect1">Especialidade</label> <select
								class="form-dropdown" name="especialidade">
								<c:forEach items="${especialidades}" var="es">
									<option value="${es.idEsp}">${es.descEsp}</option>
								</c:forEach>
							</select>
							</div>	-->
						<!--<div class="form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">* Eu aceito <a href="temos.html" class="text-warning">os termos e condições</a>, e a <a href="privacidade" class="text-warning">política de privacidade</a> da Doctoralia.</label>
                </div>-->
						<br>
						<button type="submit" class="btn btn-outline-light ">Cadastrar</button>
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