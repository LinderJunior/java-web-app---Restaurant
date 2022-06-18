<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Home</title>

	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	
	<link rel="stylesheet" type="text/css" href ="fotos.css" />
	
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
           
</head>
<body>
	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Linder's Restaurant</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li ><a href="#">Home</a></li> |
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="listarProduto">Product list</a></li>
		          <li><a href="novoProduto.jsp">Product registration</a></li>
		       </ul>
		       </li>
		       <li class="dropdown">
			        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Users
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="usuarioListar">User list</a></li>
			          <li><a  href="novoUsuario.jsp">User registration</a></li>
			       </ul>
			      </li>
			      
			      <li class="dropdown">
			        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Contributors
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="parceirosListar">list of Contributors</a></li>
			          <li><a  href="novoParceiro.jsp">Registration of Collaborators</a></li>
			       </ul>
			      </li>
		      
		      <li><a href="sobre.jsp">About Us</a></li>
		     </ul>
		     
		  
		     <ul class="nav navbar-nav navbar-right">
			      <li><a href="#" ><span class="glyphicon glyphicon-user"></span> </a></li>
			      <li><a href="usuarioListar"><span class=""></span>Edit profile</a></li>
			    
			      <li><a onclick="return confirm('Deseja realmente sair do sitema ?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
	   		 </ul>
		  </div>
		</nav>
	
	<div class="container">
		<div class="alert alert-success" role="alert">
			<h1 align="center">Wellcome <b></b></b>!</h1>
			<br/>
			Best Restaurant in the City of Quelimane. We have everything you need to keep your health up to date with the best gastronomy in high quality! Our commitment and bringing your favorite dish every day <a href="sobre.jsp">here!</a> 
		</div>
		
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  	  
 <ul id="album-fotos">
	<li id="foto01"><span>Linder</span></li>
	<li id="foto02"><span>Sergey Brin usando o Glass</span></li>
	<li id="foto03"><span>Leve e compacto</span></li>
	<li id="foto04"><span>Sensação de uma tela de 50"</span></li>
	<li id="foto05"><span>Vários tipos de lente</span></li>
	<li id="foto06"><span>Informações importantes</span></li>
	<li id="foto06"><span>Informações importantes</span></li>
	<li id="foto06"><span>Informações importantes</span></li>
	<li id="foto06"><span>Informações importantes</span></li>
	<li id="foto06"><span>Informações importantes</span></li>
</ul>
		  	  
		  <div class="carousel-inner">
		    <div class="item active">
		      <img src="fotos/home.jpg" alt="Churasco de carde de porco" width="100%" height="55%"/>
		      <div class="carousel-caption">
		        <h3>A carne mais saborosa</h3>
		        <p>Muito deliciosa, venha saborear!</p>
		      </div>
		    </div>
	
		</div>	
	</div>
	
		<dir  align="center" class="container";>
			<footer class="footer navbar-fixed-bottom">
				© 2020 Copyright - Linder's Restaurant
			</footer>
		</dir>
</body>
</html>