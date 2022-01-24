<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Lista de Produtos</title>
	
	
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
	<h1>Pesquisar os Produtos</h1>
	</br></br>

	<form method="post" action="produtoPesquisar">
		<table>
			<tr>
				<td><label for="nomeProduto">Pesquisa por nome e tipo:</label></td>
			</tr>
			<tr>
				<td><input type="text" class="form-control" name="nome" placeholder="Nome do produto"></td>
			</tr>
			<tr>
				<td>
					<div class="checkbox">
				      <select class="form-control" name="tipo">
					    <option value="">[Selecione o tipo]</option>
						<option value="Bebida">Bebida</option>
						<option value="Sobremesa">Sobremesa</option>
						<option value="Comida">Comida</option>
						<option value="Petisco">Petisco</option></select><p>
					  </select>
				    </div>
				</td>
			</tr>
		</table>
		
 	<div class="input-group mb-3">
   	 <div class="input-group-prepend">
     
     
	 	<div>
	 	 	<input type="submit" class="btn btn-primary" value="Pesquisar"/>
			<input type="reset" class="btn btn-warning" value="Limpar" />
		</div>
	</form>
	<hr>
	
	<form method="post" action="pesquisarPreco">
	 	<span class="input-group-text">
      		<table>
      			<tr>
      				<td><label for="preoProduto">Pesquisa por preço:</label></td>
      			</tr>
      			<tr>
      				<td><input type="text" class="form-control"  name="precoInicial" placeholder="Preço Inicial" required/></td>
      				<td><input type="text" class="form-control" name="precoFinal" placeholder="Preço Final"required/></td>
      			</tr>
      		</table>
      	</span>
		</br>
		
		<div>
	 	 	<input type="submit" class="btn btn-primary" value="Pesquisar"/>
			<input type="reset" class="btn btn-warning" value="Limpar"/>
		</div>
	</form>
	
	
	</div>
	
	<hr>
	
	<div class = "container">
	<h1>Lista dos Produtos</h1>
		
		<div class="btn-group" align="center">
			<form  method="post" action="relatorioProduto" target="_blank">
				 <table >
	      			<tr>
	      				<td><label for="preoProduto">Relatórios:</label></td>
	      			</tr>
	      			<tr>
	      				<td>
	      					<div class="checkbox">
						      <select class="form-control" name="tipo">
							    <option value="">[Selecione]</option>
								<option value="Bebida">Bebida</option>
								<option value="Sobremesa">Sobremesa</option>
								<option value="Comida">Comida</option>
								<option value="Petisco">Petisco</option></select><p>
							  </select>
					   		</div>	
	      				</td>
	      			</tr>
	      			<tr>
	      				<td><button class="btn btn-default" type="submit">Baixar em PDF</button></td>
	      			</tr>
	      		</table>
			</form>
		</div>
		
			
		
 	<div class="table-responsive">
		<table  class="table table-hover">
		  <caption></caption>
			<thead>
				<tr>
					<td bgcolor="#d1cdc5" align="center"><b>ID</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Nome</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Preço (Mts)</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Tipo</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Data Validade</b></td>
					<td bgcolor="#d1cdc5" align="center"><b>Acções</b></td>
				</tr>
			</thead>
		
			<c:forEach items="${listaDeProdutos}" var="produto">
				<tbody>
				<tr>
					<td align="center">${produto.id}</td>
					<td>${produto.nome}</td>
					<td align="right" ${produto.preco>800?'bgcolor=red':'bgcolor=green'}><span style="color:white;">${produto.preco}${0}</span></td>
					<td align="center" >${produto.tipo}</td>
					<td align="center" >${produto.validade}</td>
					<td align="center"><a onclick="return confirm('Deseja realmente editar o produto ${produto.nome}?')" href="produtoEditar?id=${produto.id}">Editar</a>&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;<a onclick="return confirm('Deseja realmente excluir o produto ${produto.nome}?')" href="produtoExcluir?id=${produto.id}">Excluir</a></td>
				</tr>
				
			</tbody>
			</c:forEach>
		
		</table><p><p>
		</div>
			Existem ${listaDeProdutos.size()} produtos na base de dados.
		
		</div>



		<dir  align="center" class="container";>
			<footer class="footer navbar-fixed-bottom">
				© 2020 Copyright - Linder's Restaurant
			</footer>
		</dir>
</body>
</html>