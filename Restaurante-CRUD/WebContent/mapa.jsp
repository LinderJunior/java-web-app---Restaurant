<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
 <meta charset="utf-8">
<title>Mapa de parceiros</title>

	<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    
    
    
    
	<style>
		#map {
        height: 85%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 90%;
        margin: 0;
        padding: 0;
      }
      
	</style>
</head>

<body>
 
 		
		<%
		String userName = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
			for(Cookie cookie : cookies){
			if(cookie.getName().equals("usuarioLogado")) userName = cookie.getValue();
			}
			}
			if(userName == null){
			response.sendRedirect("nao_logado.html");
			}
		%>
 <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Linder's Restaurant</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a class="nav-link" href="index.jsp">Página Inicial</a></li>
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
	
	
	
	
	<div id="map"></div>
    <script>
      function initMap() {
        // Styles a map in night mode.
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: ${parceiros.gps_latitude}, lng: ${parceiros.gps_longitude}},
          zoom: 18,
          styles: [
            {elementType: 'geometry', stylers: [{color: '#242f3e'}]},
            {elementType: 'labels.text.stroke', stylers: [{color: '#242f3e'}]},
            {elementType: 'labels.text.fill', stylers: [{color: '#746855'}]},
            {
              featureType: 'administrative.locality',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'poi',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'poi.park',
              elementType: 'geometry',
              stylers: [{color: '#263c3f'}]
            },
            {
              featureType: 'poi.park',
              elementType: 'labels.text.fill',
              stylers: [{color: '#6b9a76'}]
            },
            {
              featureType: 'road',
              elementType: 'geometry',
              stylers: [{color: '#38414e'}]
            },
            {
              featureType: 'road',
              elementType: 'geometry.stroke',
              stylers: [{color: '#212a37'}]
            },
            {
              featureType: 'road',
              elementType: 'labels.text.fill',
              stylers: [{color: '#9ca5b3'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry',
              stylers: [{color: '#746855'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry.stroke',
              stylers: [{color: '#1f2835'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'labels.text.fill',
              stylers: [{color: '#f3d19c'}]
            },
            {
              featureType: 'transit',
              elementType: 'geometry',
              stylers: [{color: '#2f3948'}]
            },
            {
              featureType: 'transit.station',
              elementType: 'labels.text.fill',
              stylers: [{color: '#d59563'}]
            },
            {
              featureType: 'water',
              elementType: 'geometry',
              stylers: [{color: '#17263c'}]
            },
            {
              featureType: 'water',
              elementType: 'labels.text.fill',
              stylers: [{color: '#515c6d'}]
            },
            {
              featureType: 'water',
              elementType: 'labels.text.stroke',
              stylers: [{color: '#17263c'}]
            }
          ]
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAr7IsmxAoq6LFtnxCbhem6dXi5NHfvNng&callback=initMap"
    async defer></script>
	
	<br/><br/>
	
	<div align="center" >
		<iframe width="560" height="315" 
		src="${parceiros.youtube_videouid}" 
		frameborder="0" 
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
		allowfullscreen></iframe>
	</div>
	
	 
  	<dir align="center" class="container";>
		<footer class="footer navbar-fixed-bottom">
			© 2020 Copyright - Linder's Restaurant &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Visite nos: <a href="https://web.facebook.com/?ref=tn_tnmn" target="_blank">Facebook</a> | <a href="https://www.instagram.com/?hl=en" target="_blank">Instagram</a>
		</footer>
	</dir>
 
</body>
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
</html>