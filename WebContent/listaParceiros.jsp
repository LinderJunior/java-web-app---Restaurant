<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Lista de Parceiros</title>

	<link rel="stylesheet" href="css/bootstrap.css"/>
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
	      <li ><a href="index.jsp">P?gina Inicial</a></li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Produtos
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="listarProduto">Lista de Produtos</a></li>
	          <li><a href="novoProduto.jsp">Cadastro de Produto</a></li>
	       </ul>
	       </li>
	       <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usu?rios
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="usuarioListar">Lista de Usu?rios</a></li>
		          <li><a href="novoUsuario.jsp">Cadastro de Usu?rios</a></li>
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
	      <li><a href="sobre.jsp">Sobre N?s</a></li>
	     </ul>
	     <ul class="nav navbar-nav navbar-right">
		      
		      <li><a onclick="return confirm('Deseja realmente sair do sitema <>?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
   		 </ul>
	  </div>
	</nav>
	

	<div class = "container">
	<h2>Lista de Parceiros</h2>
		
		
		
		
 	<div class="table-responsive">
		<table  class="table table-hover">
		  <caption></caption>
			<thead>
				<tr>
					<td bgcolor="#d1cdc5" align="center"><b>ID</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Email</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Latitude</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Longitude</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Telefone</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Detalhes</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Ac??es</b></td>
				</tr>
			</thead>
		
			<c:forEach items="${listaDosParceiros}" var="parceiros">
				<tbody>
				<tr>
					<td align="center">${parceiros.id}</td>
					<td align="center">${parceiros.email}</td>
					<td align="center">${parceiros.gps_latitude}</td>
					<td align="center">${parceiros.gps_longitude}</td>
					<td align="center">${parceiros.telefone}</td>
					<td align="center"><a href="mapa?id=${parceiros.id}">Visualizar</a></td>
					<td align="center"><a onclick="return confirm('Deseja realmente editar ${parceiros.email}?')" href="parceirosEditar?id=${parceiros.id}">Editar</a>&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;<a onclick="return confirm('Deseja realmente excluir  ${parceiros.email}?')" href="parceirosExcluir?id=${parceiros.id}">Excluir</a></td>
				</tr>
				
			</tbody>
			</c:forEach>
		
		</table>
		<dir align="center" class="container";>
			<footer class="footer navbar-fixed-bottom">
			? 2020 Copyright - Linder's Restaurant
		</footer>
</body>
</html>