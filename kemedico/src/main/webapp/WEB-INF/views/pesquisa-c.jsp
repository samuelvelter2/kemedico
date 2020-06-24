<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- Meta tags Obrigat�rias -->
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


<!------ Include the above in your HEAD tag ---------->
<script>
	$(document).ready(function() {
		$("#select-especialidades").select2({

		});
		$("#select-plano").select2({

		});
		$("#select-meios").select2({

		});

		$("#select-bairro").select2({

		});
	});
</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/painel.css"></c:url>'>

<!-- HTML5Shiv -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

<link rel="stylesheet" type="text/css"
	href='<c:url value = "/resources/css/estilo.css"></c:url>'>


<title>Kem�dico - N�s temos m�dicos</title>

<meta charset="ISO-8859-1">
<title>Kemedico - Resultados da Busca de Cl�nica</title>
</head>
<body>
	<section class="our-webcoderskull padding-lg  col-md-12">
		<form:form modelAttribute="pesquisa"
			servletRelativeAction="${s:mvcUrl('pesquisar').build() }"
			method="get">
			<hr class="col-md-4">
			<!--Filtro-->
			<div class="container form-inline float-none"
				style="background-color: #007bff">
				<p class="text-dark bg-light m-3 p-3">FILTROS</p>

				<div class="dropdown  m-3">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">M�todos de
						Pagamento</button>
					<div class="dropdown-menu " aria-labelledby="dropdownMenuButton">
						<form:select id="select-meios" path="meios" class="custom-select"
							name="planos" multiple="true" itemLabel="selecione pelo menos um">
							<c:forEach items="${pesquisa.meios}" var="meio">
								<option value="${meio.idMeio}" label="${meio.descMeio}"
									selected="selected"></option>
							</c:forEach>
							<form:options items="${meios}" itemValue="idMeio"
								itemLabel="descMeio" />
						</form:select>
						<div class="text-center">
							<hr>
							<button type="submit" class="btn btn-primary col-sm-6  ">Aplicar</button>
						</div>

					</div>
				</div>
				<div class="dropdown m-3 ">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Convenios</button>
					<div class="dropdown-menu " aria-labelledby="dropdownMenuButton">
						<form:select multiple="true" class="custom-select"
							id="select-plano" path="planos">
							<c:forEach items="${pesquisa.planos }" var="plano">
								<option value="${plano.id }" selected="selected"></option>
							</c:forEach>
							<form:options class="text-centered" items="${planos}"
								itemValue="id" itemLabel="nomePlano"></form:options>
						</form:select>
						<div class="text-center">
							<hr>
							<button type="submit" class="btn btn-primary col-sm-6  ">Aplicar</button>
						</div>



					</div>

				</div>
				<div class="dropdown m-3">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Bairros</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<form:select multiple="true" class="custom-select"
							id="select-bairro" path="planos">
							<c:forEach items="${pesquisa.bairros }" var="bairro">
								<option value="${bairro.idBairro }" selected="selected"></option>
							</c:forEach>
							<form:options class="text-centered" items="${bairros}"
								itemValue="idBairro" itemLabel="nomeBairro"></form:options>
						</form:select>
						<div class="text-center">
							<hr>
							<button type="submit" class="btn btn-primary col-sm-6  ">Aplicar</button>
						</div>

					</div>



				</div>
			</div>
		</form:form>
		<div class="container">
			<div class="row heading heading-icon">
				<c:if test="${not empty pesquisa}"></c:if>
				<h3 class="text-white p-5">${pesquisa.especialidade.descEsp} em
					${pesquisa.cidade.nomeCidade}</h3>

			</div>
			<ul class="row">
				<c:if test="${not empty resultado.resultados}">
					<c:forEach items="${resultado.resultados}" var="clinica">
						<li class="col-12 col-md-6 col-lg-3">
							<div class="cnt-block equal-hight" style="height: 420px;">
								<figure>
									<img
										src="${s:mvcUrl('foto').arg(0,clinica.fotoPerfil.idFoto).build()}"
										class="img-responsive" alt="">
								</figure>
								<h3>
									<a href="${s:mvcUrl('clinica').arg(0,clinica.id).build()}"
										style="color: #daa520">${clinica.nomeCompleto}</a>
								</h3>
								<h5>${pesquisa.especialidade.descEsp}</h5>
								<ul class="follow-us clearfix">
									<li><a href="#"><i class="fas fa-map-marker-alt"></i>&nbsp;
											${clinica.bairro.nomeBairro} , ${clinica.cidade.nomeComUF}</a></li>
								</ul>
								<i class="fa fa-star" style="color: #FFD700; font-size: 35px"></i>
								<fmt:formatNumber maxFractionDigits="2"
									value="${clinica.mediaAvaliada }"></fmt:formatNumber>

							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<!--<div class="dropdown">
                      <button onclick="myFunction()" class="dropbtn">Dropdown</button>
                      <div id="myDropdown" class="dropdown-content">
                        <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
                        <a href="#about">About</a>
                        <a href="#base">Base</a>
                        <a href="#blog">Blog</a>
                        <a href="#contact">Contact</a>
                        <a href="#custom">Custom</a>
                        <a href="#support">Support</a>
                        <a href="#tools">Tools</a>
                      </div>
                    </div>-->

		</div>

	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<!--  <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>-->
</body>
<%@ include file="/WEB-INF/views/rodape.jsp"%>
</html>