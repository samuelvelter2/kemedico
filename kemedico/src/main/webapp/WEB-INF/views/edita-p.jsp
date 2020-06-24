<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- Estilo customizado -->
<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>

<title>Kémédico - Editar Paciente</title>

</head>
<body>
	<section id="recursos" class="caixa">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<br> <br>
					<hr class="col-md-4">
					<h2>Editar Paciente</h2>
					<form:form class="was-validated"
						action="${s:mvcUrl('pac_updt').build()}" method="post"
						modelAttribute="pac">
						<div class="form-row">
							<div class="col-md-5 mb-3">
								<label for="validationDefault01">Nome completo*:</label> <input
									id="Nome" name="nomeCompleto" placeholder="Ex.:Marcio Jose"
									class="form-control input-md" value="${pac.nomeCompleto }" required type="text" required>
							</div>
							<div class="col-md-3 mb-3">
								<label for="validationDefault01">Nick*:</label> <input id="Nome"
									name="apelido" placeholder="Ex.:Marcinho"
									class="form-control input-md" value="${pac.apelido}" required type="text" required>
							</div>
							<div class="col-md-3 mb-3">
								<label for="validationDefault02">Email*:</label> <input
									id="prependedtext" name="email" class="form-control"
									placeholder="email@email.com" required type="text" value="${pac.email }"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
							</div>
							<div class="form-row">
								<div class="col-md-3 mb-3">
									<label for="validationDefault03">CPF*:</label> <input id="cpf"
										name="numeroCPF" placeholder="Apenas números" value="${pac.numeroCpf}"
										class="form-control input-md" required type="text"
										maxlength="14"  required OnKeyPress="formatar('###.###.###-##', this)">
								</div>
								<div class="col-md-4 mb-3">
									<label for="validationDefault04">Data de Nascimento*:</label> <input
										id="dtnasc" name="dataNasc" placeholder="DD/MM/AAAA"
										class="form-control input-md" required type="text" value="${dataNasc}"
										maxlength="10" OnKeyPress="formatar('##/##/####', this)"
										onBlur="showhide()" required>
								</div>
								<div class="col-md-4 mb-3">
									<label for="validationDefault05">Telefone Celular*:</label> <input
										id="prependedtext" name="prependedtext" class="form-control"
										placeholder="XX XXXXX-XXXX" type="text" maxlength="13"
										pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$" value="${numeroCelular}"
										OnKeyPress="formatar('## #####-####', this)" required>
								</div>
							</div>
							<hr class="my-4">
						</div>



						<div class="form-row">

							<div class="col-md-2 mb-3">

								<div class="form-group">
									<div class="">
										<label for="validationTextarea">Estado: *</label>
										<form:select id="exampleInputPassword1"
											path="estadoPaciente.idUF" class="custom-select"
											name="especialidade" required="required">
											<form:option value="-1" selected="selected" hidden="hidden"
												disabled="true">-- Escolher Um --</form:option>
											<form:options items="${estados}" itemValue="idUF"
												itemLabel="nomeUF" />
										</form:select>
									</div>

								</div>



							</div>
							
							<div class="form-check col-md-12 m-4">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name="check" required="required"> <label
									class="form-check-label text-white" for="exampleCheck1">*
									Eu aceito os termos e condições, e a política de privacidade da
									kemedico.</label>

							</div>
							<div class="custom-file col-md-3">
							<button type="submit" class="btn btn-outline-light">Atualizar</button>
						</div>		
						<div class="custom-file col-md-3">
							<button type="button" class="btn btn-danger">Excluir Conta</button>
							</div>

					</form:form>

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
