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
									src="${s:mvcUrl('foto_prof').arg(0, profsau.id.toString()).build()}"
									class="img-fluid" width="200px">
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Nome:</th>
								<td>${profsau.nomeCompleto}</td>

							</tr>
							<tr>
								<th scope="row">Especialização:</th>
								<td>${profsau.especializacao.descEsp}</td>

							</tr>
							<tr>
								<th scope="row">Consultorio:</th>
								<td>CONSULTÓRIO DE PEDIATRIA DR ROBERTO FERNANDES MACHADO</td>

							</tr>
							<tr>
								<th scope="row">Endereço:</th>
								<td>Rua Firmino Fragoso, 144, Madureira, Madureira, Rio de
									Janeiro</td>

							</tr>
							<tr>
								<th scope="row">Email:</th>
								<td>${profsau.email}</td>

							</tr>
							<tr>
								<th scope="row">Formas de Pagamento:</th>
								<td>Cartão de Débito, Cartão de Crédito, Dinheiro</td>

							</tr>
							<tr>
								<th scope="row">Telefone:</th>
								<td>(21) 3952-5354</td>

							</tr>
							<tr>
								<th scope="row">Valor Consulta:</th>
								<td>R$ 120
								<td>
							</tr>

						</tbody>
					</table>

				</div>


			</div>

		</div>

	</section>	

	 <%@ include file="/WEB-INF/views/rodape.jsp" %>
</body>
</html>