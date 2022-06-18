<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Sobre o Restaurante</title>

	<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
	<style>
		table {
		  font-family: arial, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		
		td, th {
		  border: 1px solid #dddddd;
		  text-align: left;
		  padding: 8px;
		}
		
		tr:nth-child(even) {
		  background-color: #dddddd;
		}
	</style>
</head>

<body>
 

	
		<%
		String userName = null;

		%>
 <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Linder's Restaurant</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a class="nav-link" href="index.jsp">Pagina Inicial</a></li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Produtos
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="listarProduto">Lista de Produtos</a></li>
	          <li><a href="novoProduto.jsp">Cadastro de Produto</a></li>
	       </ul>
	      </li>
	      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuarios
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="usuarioListar">Lista de Usuarios</a></li>
		          <li><a href="novoUsuario.jsp">Cadastro de Usuarios</a></li>
		       </ul>
		     </li>
		     
		     <li class="dropdown">
			        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Parceiros
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="parceirosListar">Lista de Parceiros</a></li>
			          <li><a  href="novoParceiro.jsp">Cadastro de Parceiros</a></li>
			       </ul>
			      </li>
			      
	      <li><a href="sobre.jsp">Sobre Nos</a></li>
	     </ul>
	     <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=userName%></a></li>
		      <li><a onclick="return confirm('Deseja realmente sair do sitema <%=userName%>?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
   		 </ul>
	  </div>
	</nav>
	
	
	
	
	<div class="container">
	<h1 align="center">Linder's Restaurante</h1>
	We are a restaurant of the highest quality in the market.
	Our commitment is to bring the best to our customers and always make their favorite dishes available whenever they need it.
	We are located in the city of Quelimane, in the Aeroporto
	Thank you very much to everyone who has the Linder Restaurant as their home number 1 of the Meals.
	Come back whenever you can.
	<br>
		
		<b>Location</b><br>
	    Caixa Postal: 2400 na Cidade de Quelimane, Zambezia. <br>
		Cell: +258 846978018 E-mail: linderju01@@gmail.com. 	
				
	</div>
	
	
	
	
	
 
 <div class="content">
 </div>
 <dir align="center" class="container";>
	<footer class="footer navbar-fixed-bottom">
		© 2020 Copyright - Linder's Restaurant &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Visite nos: <a href="https://web.facebook.com/?ref=tn_tnmn" target="_blank">Facebook</a> | <a href="https://www.instagram.com/?hl=en" target="_blank">Instagram</a>
	</footer>
</dir>
 
</body>
</html>