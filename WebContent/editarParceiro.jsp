<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
	
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	

<title>Update collaborators</title>
   
    
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
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> </a></li>
		      <li><a onclick="return confirm('Deseja realmente sair do sitema <>?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
   		 </ul>
		  </div>
		</nav>



<div class = "container">
<h1>Update collaborators </h1>
</br></br>
	<form  method="post" class="" action="parceirosEditar">
				
	  	<div class="table-responsive">
			<table >
				<tr>
					<td><label for="nomeProduto">ID:</label></td>
					<td><input type="text" class="form-control" readonly="readonly" id="id" name="id" value="${parceiros.id}" /></td>
				</tr>
				<tr>
					<td><label for="PrimeiroNome">Email:</label></td>
					<td><input type="email" class="form-control" name="email" required value="${parceiros.email}" placeholder="@exemplo.com"/></td>
				</tr>
				<tr>
					<td><label for="UltimoNome">Latitude:</label></td>
					<td><input type="text" class="form-control" name="gps_latitude" required value="${parceiros.gps_latitude}"/></td>
				</tr>
				<tr>
					<td><label for="usuario">Longitude:</label></td>
					<td><input type="text" class="form-control" name="gps_longitude" width="50%" required value="${parceiros.gps_longitude}"/></td>
				</tr>
				<tr>
					<td><label for="senhaUsuario">Cell:</label></td>
					<td><input type="text" class="form-control" name="telefone" required value="${parceiros.telefone}"/></td>
				</tr>
				<tr>
					<td><label for="ContactoUsuario">YouTube Video Uid:</label></td>
					<td><input type="text" class="form-control" name="youtube_videouid" required value="${parceiros.youtube_videouid}"/></td>
				</tr>
								
		  	</table>
		  </div>
		 
			
	     <br/><br/>
	    
	 	<input type="submit" class="btn btn-primary" value="Salvar"/>
		<input type="reset" class="btn btn-warning" value="Limpar"/>
	</form>
	
	<dir align="center" class="container";>
		<footer class="footer navbar-fixed-bottom">
			© 2020 Copyright - Linder's Restaurant
		</footer>
	</dir>
	</div>

</body>
<
</html>