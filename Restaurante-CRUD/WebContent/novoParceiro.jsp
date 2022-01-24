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
	

	
<title>Cadastro de Parceiros</title>


   
    <script>
				window.addEventListener( "pageshow", function ( event ) {
				var historyTraversal = event.persisted ||
				( typeof window.performance != "undefined" &&
				window.performance.navigation.type === 2 );
				if ( historyTraversal ) {
				window.location.reload();
				}
				}); 
				
			</script>
			
				<%
				String usuario = null;
			
				
					Cookie[] cookies = request.getCookies();
					if(cookies !=null){
					for(Cookie cookie : cookies){
					if(cookie.getName().equals("usuarioLogado")) usuario = cookie.getValue();
					}
					}
					if(usuario == null){
					response.sendRedirect("nao_logado.html");
					System.out.print("Nao logado Menu");
					}
				%>
				


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
			      <li><a href="index.jsp">Página Inicial</a></li>
			      <li class="dropdown">
			        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Produtos
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="listarProduto">Lista de Produtos</a></li>
			          <li><a href="novoProduto.jsp">Cadastro de Produto</a></li>
			       </ul>
			      </li>
			
		      
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuários
		        <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="usuarioListar">Lista de Usuários</a></li>
		          <li><a href="novoUsuario.jsp">Cadastro de Usuários</a></li>
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
			          
		      <li><a href="sobre.jsp">Sobre Nós</a></li>
	     </ul>
	     <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=userName%></a></li>
		      <li><a onclick="return confirm('Deseja realmente sair do sitema <%=userName%>?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
   		 </ul>
		  </div>
		</nav>



<div class = "container">
<h1>Cadastro de novo parceiro </h1>
</br></br>
	<form  method="post" class="" action="parceirosRegistar">
				
	  	<div class="table-responsive">
			<table >
				<tr>
					<td><label for="PrimeiroNome">Email:</label></td>
					<td><input type="email" class="form-control" name="email" required value="" placeholer="@exemplo.com"/></td>
				</tr>
				<tr>
					<td><label for="UltimoNome">Latitude:</label></td>
					<td><input type="text" class="form-control" name="latitude" required value=""/></td>
				</tr>
				<tr>
					<td><label for="usuario">Longitude:</label></td>
					<td><input type="text" class="form-control" name="longitude" width="50%" required value=""/></td>
				</tr>
				<tr>
					<td><label for="senhaUsuario">Telefone:</label></td>
					<td><input type="text" class="form-control" name="telefone" required value=""/></td>
				</tr>
				<tr>
					<td><label for="ContactoUsuario">YouTube Video Uid:</label></td>
					<td><input type="text" class="form-control" name="youtube" required value=""/></td>
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