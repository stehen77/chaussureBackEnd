<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<title>Chaussures de Sport</title>
<%-- <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"> --%>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
        rel="stylesheet"  type="text/css" />
<!-- <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> -->
</head>
<body>
<a href=" <c:url value ="/j_spring_security_logout" />"> Logout</a>
	<h1>Binvenu sur notre site</h1>

	<P>Bienvenue chez TTT ! Avec plus de 720 marques et 40966 modèles,
		vous trouverez forcément chaussure à votre pied ! Promenez-vous dans
		nos nombreuses boutiques, pour profiter de nos soldes chaussures deux
		fois par an, et de l’arrivée saisonnière de nos Nouvelles Collections
		. Retrouvez des Chaussures Femme, Homme et Enfant , de la plus petite
		à la plus grande pointure ! Que vous soyez derbies ou mocassins,
		talons hauts ou sacs à main de luxe, entre petits prix et maxi choix,
		TTT vous promet une saison hautement stylée. Vous venez ?</P>
		
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Taille</th>
			<th>Quantité</th>
			<th>Model</th>
			<th>Prix</th>
			
		</tr>
		<c:forEach items="${articles }" var="a">
			<tr>
				<td>${a.id_article }</td>
				<td>${a.taille }</td>
				<td>${a.quantite_stock }</td>
				<td>${a.model.nom_model }</td>
				<td>${a.model.description }</td>
				<td>${a.model.prix_unitaire }</td>
				
			</tr>

		</c:forEach>
	</table>
	<c:forEach items="${categories }" var="m">
			<tr>
				<td>${m.id_categorie }</td>
				<td>${m.nom_cat }</td>
				<%--  <td>${m.model.nom_model }</td>  --%>
				
				
				
			</tr>

		</c:forEach>
		<br>
		<c:forEach items="${models }" var="l">
			<tr>
				<td>${l.id_model }</td>
				<td>${l.nom_model }</td>
				
				
				
				
			
				
				
			</tr>

		</c:forEach>
</body>
</html>
