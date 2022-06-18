<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<title>Cadastro de Produto</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
   <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	

				
	
	
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
		      </li>
		      <li><a href="sobre.jsp">Sobre Nós</a></li>
	     </ul>
		     
		 <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <></a></li>
		      <li><a onclick="return confirm('Deseja realmente sair do sitema <>?')" href="Logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
   		 </ul>
		  </div>
		</nav>



	<div class = "container">
			
		
      <h1>Adicionar novo Produto</h1>
       </br> </br>
        
	
	  <form action="novoProduto" method="post">
	  	<div class="table-responsive">
			<table > 
			    <tr>
					<td><label for="nomeProduto">Nome do produto:</label></td>
					<td><input type="text" class="form-control" name="nome" value="${produto.nome}" required/></td>
				</tr>
			    <tr>
					<td><label for="preco">Preço:</label></td>
					<td><input type="text" class="form-control" name="preco" value="${produto.preco}" required/></td>
				</tr>
			    <tr>
					<td><label for="tipoProduto">Tipo de produto:</label></td>
					<td>
						<div class="checkbox">
					      <select class="form-control" name="tipo" value="${produto.tipo}"  required/>
						    <option value="">[Selecione]</option>
							<option value="Bebida">Bebida</option>
							<option value="Sobremesa">Sobremesa</option>
							<option value="Comida">Comida</option>
							<option value="Petisco">Petisco</option></select><p>
						  </select>
			    </div>

				
				 <tr>
					<td><label for="nomeProduto">Data Validade:</label></td>
					<td><input type="date" name="validade"  data-date-format="dd/MM/yyyy" class="form-control" placeholder="dd-MM-yyyy"></td>
				</tr>
			    
			    
					
					
				</tr>
			</table>
		
	
	    </br>
	    
	 	<input type="submit" class="btn btn-primary" value="Salvar"/>
		<input type="reset" class="btn btn-warning" value="Limpar"/>
	
	</div>
	</form>
	
	<dir align="center" class="container";>
		<footer class="footer navbar-fixed-bottom">
			© 2020 Copyright - Linder's Restaurant
		</footer>
	</dir>
	
	
</body>
</html>