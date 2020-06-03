<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-4">
		<br> <br> <br>		
		<form:form method="POST" action="${s:mvcUrl('cad_ps_bd').build()}"
			modelAttribute="profsaude">
			<div class="form-group">
				<label for="exampleInputEmail1">Nome do Plano</label> <input
					name="nomePlano" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
			</div>
			<br>
			<button type="submit" class="btn btn-outline-light ">Cadastrar</button>
		</form:form>
	</div>
</body>
</html>