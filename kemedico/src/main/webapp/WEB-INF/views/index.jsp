<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    <%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!-- HTML5Shiv -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->

    <!-- Estilo customizado -->
  

    <title>Health Clinics</title>
    
  </head> 
  <body>
    
    

    <section id="home" class="d-flex"><!--home -->
      <div class="container align-self-center"><!--container -->
        <div class="row"><!--row -->
          <div class="col-md-12 capa">
            
            <div id="carousel-spotify" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner"><!--Inner -->
                
                <div class="carousel-item active">
                  <h1>Saúde para todos</h1>
                  
                  <!--<a href="" class="btn btn-lg btn-custom btn-roxo">
                   Agende agora sua consulta
                  </a>-->

                 

                </div>

                <div class="carousel-item">
                  <h1>Os melhores especialistas</h1>
                  
                  <a href="agendar.html" class="btn btn-lg btn-custom btn-branco">
                    Agendar agora
                  </a>
                </div>

              </div><!--/Inner -->

              <!-- Controles -->
              <a href="#carousel-spotify" class="carousel-control-prev" data-slide="prev">
                <i class="fas fa-angle-left fa-3x"></i>
              </a>

              <a href="#carousel-spotify" class="carousel-control-next" data-slide="next">
                <i class="fas fa-angle-right fa-3x"></i>
              </a>

            </div>

          </div>
        </div><!--/row -->
      </div><!--/container -->
    </section><!--/home -->

    <section id="servicos" class="caixa">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="row albuns">
              <div class="col-md-6">
                <img src='<c:url value = "/resources/imagens/img1.png"></c:url>' class="img-fluid">
              </div>
              <div class="col-md-6">
                <img src='<c:url value ="/resources/imagens/img2.png"></c:url>' class="img-fluid">
              </div>
            </div>
            <div class="row albuns">
              <div class="col-md-6">
                <img src='<c:url value ="/resources/imagens/img3.png"></c:url>' class="img-fluid">
              </div>
              <div class="col-md-6">
                <img src='<c:url value ="/resources/imagens/img4.png"></c:url>' class="img-fluid">
              </div>
            </div>
          </div>
          <div class="col-md-6">
            
            <h2>O que a Health Clinics tem?</h2>

            <h3>Especialistas</h3>
            <p>A Health Clinics tem milhares de especialistas. Consulte sempre com seu medico favorito. E marque a qualquer momento.</p>

            <h3>Cadastros Gratuitos </h3>
            <a href="c-especialista.html" title="">Registrar-se gratuitamente como especialista.</a>
            <br>
            <a href="c-paciente.html" title="">Registrar-se gratuitamente como paciente</a>
            <br>
           

          </div>
        </div>
      </div>
    </section>


    <section id="recursos" class="caixa">
      <div class="container">
        <div class="row">
          <div class="col-md-4">

            <h2>Fácil</h2>
            <h3>Buscar</h3>
            <p>Coloque a especialidade que deseja e o estado que se encontra no momento e o resto é com a gente.
            </p>

            <h3>Receba lembretes</h3>
            <p>Confirmamos tudo imediatamente pelo email informado e, antes da consulta, um lembrete será enviado via celular.
            </p>

            <h3>Avalie o serviço</h3>
            <p>Após a consulta você poderá deixar sua opinião sobre o serviço. Tudo isso de forma gratuita, simples e rápida.
            </p>

          </div>

          <div class="col-md-8">
            <div class="row rotacionar">
              <div class="col-md-6">
                <img src='<c:url value ="/resources/imagens/iphone1.png"></c:url>' class="img-fluid">
              </div>
              <div class="col-md-6">
                <img src='<c:url value ="/resources/imagens/iphone1.png"></c:url>' class="img-fluid">
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

   

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
 <%@ include file="/WEB-INF/views/rodape.jsp" %>
