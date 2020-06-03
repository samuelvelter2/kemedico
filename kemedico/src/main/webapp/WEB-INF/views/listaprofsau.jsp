<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Listagem dos profissionais de saude cadastrados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<section id="recursos" class="caixa">
		<div class="container">

			<div class="row">
				<div class="col-md-8">
					<br> <br> <br> <br>
					<p>
						mensagem
						<c:out value="${mensagem}"></c:out>
					</p>
				</div>
				<div class="row">
					<div class="col-md-4">
						<br> <br> <br>
						<table id="table-1" class="table table-bordered table-dark">
							<thead>
								<tr>
									<th>id</th>
									<th>Email</th>
									<th>Nome Completo</th>
									<th>Número do Celular</th>
									<th>Data de nascimento</th>
									<th>Numero do CPF</th>
									<th>crm</th>
									<th>ver</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${profsau}" var="ps">
									<tr>
										<td>${ps.nomeCompleto}</td>
										<td>${ps.email}"></td>										
										<td>${ps.numeroCelular}</td>
										<td>${ps.dataNascimento}</td>
										<td>${ps.numeroCpf}"</td>
										<td>${ps.crm}</td>
										<td><a href= "${s:mvcUrl('prof_saude').arg(0, ps.id.toString()).build()}">Ver</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
<%@ include file="/WEB-INF/views/rodape.jsp"%>