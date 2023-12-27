<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition des produits</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Modification des Produits
  </div>
  <div class="card-body">
      <form action="Editer.do" method="post" >
      <div  class="form-group"  >
      
       <label class="control-label">ID_Produit :</label>
       <input type="text" name="id" class="form-control" value="${produit.ID_Produit}"/>
      </div>
      <div class="form-group">
       <label class="control-label">Nom_Produit :</label>
       <input type="text" name="nom" class="form-control" value="${produit.Nom_Produit}"/>
      </div>
      <div class="form-group">
       <label class="control-label">PRIX :</label>
       <input type="text" name="prix" class="form-control" value="${produit.PRIX}"/>
      </div>
      <div>
        <button type="submit" class="btn btn-primary">Modifier</button>
      </div>
      </form>     
  </div>
</div>
</div>
</body>
</html>