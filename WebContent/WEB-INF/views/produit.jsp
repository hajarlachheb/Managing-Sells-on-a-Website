<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
<link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Liste des produits</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
body {
 background-image: url("GestionAchatsMVC/WEB-INF/IMAGE.jpg");
 background-color: #FFFF00;
}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #00FFFF;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}


.container {
  padding: 16px;
}



@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
table{
  width:100%
}
table,th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
<b> On vous souhaite la bienvenue ! <c:out value="${login}"></c:out></b>

<form id='form' action="/GestionAchatsMVC/AjouterProduit.do" method="post">
  <div class="container">
  <c:set var="addMsg" value ="${msg }"/>
  <c:if test="${addMsg!=null }">
  	<p><c:out value="${addMsg }"></c:out></p>
  </c:if>

    <input type="text" placeholder="Nom du produit" name="NOM_PRODUIT" value="" required>

	<input type="text" placeholder="Prix adequat" name="PRIX"  value="" required>

    <input type="text" placeholder="Fournisseur" name="FOURNISSEUR"  value="" required>
        
    <button type="submit">Valider</button>
  </div>
</form>

<table  id="table" onload="onloadTable()">
  <tr>
    <th>Produit</th>
    <th>Prix</th>
    <th>Fournisseur</th>
    <th>Suppression<th>Edition</th>
  </tr>
  <c:forEach items="${Gestiondeproduit}" var="p">
  	<tr>
  	<td>
  	<c:out value="${p.NOM_PRODUIT }"></c:out>
  	</td>
  	<td>
  	<c:out value="${p.PRIX }"></c:out>
  	</td>
  	<td>
  	<c:out value="${p.FOURNISSEUR }"></c:out>
  	</td>
  	 <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimer.do?id=${p.ID_PRODUIT }">Supprimer</a></td>
               <td><a href="editer.do?id=${p.ID_PRODUIT }">Editer</a></td>
  	</tr>
  </c:forEach>
</table>
</body>
</html>