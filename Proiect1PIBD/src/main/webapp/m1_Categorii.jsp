<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Categorii</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Categorii:</h1>
	<br />
	<p align="center">
		<a href="nou_Categorii.jsp"><b>Adauga o noua categorie.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceLinieDupaId("categorii", "idcategorii", aux);
	rs.first();
	String Nume = request.getParameter("nume");
	String Popularitate = request.getParameter("popularitate");
	String Tara = request.getParameter("tara");
	rs.close();
	jb.disconnect();
	%>
	<form action="m2_Categorii.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdCategorii:</td>
				<td><input type="text" name="idcategorii" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">Nume:</td>
				<td><input type="text" name="nume" size="30" value="<%=Nume%>" /></td>
			</tr>
			<tr>
				<td align="right">Popularitate:</td>
				<td><input type="text" name="popularitate" size="30"
					value="<%=Popularitate%>" /></td>
			</tr>
			<tr>
				<td align="right">Tara:</td>
				<td><input type="text" name="tara" size="30"
					value="<%=Tara%>" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="Modifica linia">
		</p>
	</form>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
</html>