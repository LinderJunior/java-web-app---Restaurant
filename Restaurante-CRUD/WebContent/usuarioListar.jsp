<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Lista de Usuários</title>

	<link rel="stylesheet" href="css/bootstrap.css"/>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    
       
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
	      <li ><a href="index.jsp">Página Inicial</a></li>
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
	<h2>Lista dos Usuarios</h2>
		<div class="btn-group">
			<form  method="post" action="relatorioUsuario" target="_blank">
				<button class="btn btn-default" type="submit">Baixar em PDF</button>
			</form>
		</div>
		
		
		
		
 	<div class="table-responsive">
		<table  class="table table-hover">
		  <caption></caption>
			<thead>
				<tr>
					
					<td bgcolor="#d1cdc5" align="center"><b>Id</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Usuario</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Contacto</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Email</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Nivel</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Acções</b></td>
				</tr>
			</thead>
		
			<c:forEach items="${listaDeUsuarios}" var="usuario">
				<tbody>
				<tr>
					<td  align="center">${usuario.id_usuario}</td>
					<td  align="center">${usuario.usuario}</td>
					<td  align="center">${usuario.contacto}</td>
					<td  align="center">${usuario.email}</td>
					<td align="center">${usuario.nivel_acesso}</td>
					<td align="center"><a onclick="return confirm('Deseja realmente editar o Usuario ${usuario.usuario}?')" href="updateUsuario?id_usuario=${usuario.id_usuario}">Editar</a>&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;<a onclick="return confirm('Deseja realmente excluir o Usuario ${usuario.usuario}?')" href="removerUsuario?id_usuario=${usuario.id_usuario}">Excluir</a></td>
				</tr>
				
			</tbody>
			</c:forEach>
		
		</table>
		<dir align="center" class="container";>
			<footer class="footer navbar-fixed-bottom">
			© 2020 Copyright - Linder's Restaurant
		</footer>
</body>
</html>