<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
<meta charset="ISO-8859-1"><meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
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
  background-color: #CCEEFF;
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

span.psw {
  float: right;
  padding-top: 16px;
}


@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
}
</style>
</head>
<body>

<h2>Formulaire d'authentification</h2>

<form action="/GestionAchatsMVC/login.do" method="post">
  <div class="container">
  <c:set var="errorMsg" value ="${msg }"/>
  <c:if test="${errorMsg!=null }">
  	<p><c:out value="${errorMsg }"></c:out></p>
  </c:if>
  
    <label for="uname"><b>Nom d'utilisateur</b></label>
    <input type="text" placeholder="Veuillez entrer votre nom d'utilisateur" name="nomutilisateur" required>

    <label for="psw"><b>Mot de passe</b></label>
    <input type="password" placeholder="Veuillez entrer votre mot de passe" name="motdepasse" required>
        
    <button type="submit">Log in</button>
  </div>
</form>
</body>
</html>