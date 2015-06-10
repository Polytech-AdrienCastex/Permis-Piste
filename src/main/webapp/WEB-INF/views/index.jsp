<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des Jeux</title>

<script language=javascript>
   function Chargement()
  {
      var obj = document.getElementById("id_erreur");
      if (obj.value!='')
         alert('Erreur signalée  : "'+obj.value+"'");
  }
  </script>
</head>
<body  onLoad="Chargement();">
<input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
  <H1>  Bienvenue dans l'application Permis Piste</H1>
   <a href="afficherJeux.htm">Voir la liste des jeux</a><br></br>
</body>
</html>
