<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Metadata</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Metadata:</h1>
	<br />
	<p align="center">
		<a href="nou_Metadata.jsp"><b>Adauga Metadata.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int aux = java.lang.Integer.parseInt(request.getParameter("idmetadata"));
	String idfilm = request.getParameter("idfilme");
	String idcategorie = request.getParameter("idcategorii");
	String an_de_lans = request.getParameter("an_de_lansare");
	String lang = request.getParameter("limba");
	String[] valori = { idfilm, idcategorie, an_de_lans, lang };
	String[] campuri = { "idfilme", "idcategorii", "an_de_lansare", "limba" };
	jb.modificaTabela("metadata", "idmetadata", aux, campuri, valori);
	jb.disconnect();
	%>
	<h1 align="center">Modificarile au fost efectuate !</h1>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
</html>