<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Film</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Filme:</h1>
	<br />
	<p align="center">
		<a href="nou_Film.jsp"><b>Adauga un nou film.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceLinieDupaId("filme", "idfilme", aux);
	rs.first();
	String Nume = request.getParameter("nume");
	String Durata = request.getParameter("durata");
	String Rating = request.getParameter("rating");
	rs.close();
	jb.disconnect();
	%>
	<form action="m2_Film.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdFilm:</td>
				<td><input type="text" name="idfilme" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">Nume:</td>
				<td><input type="text" name="nume" size="30" value="<%=Nume%>" /></td>
			</tr>
			<tr>
				<td align="right">Durata:</td>
				<td><input type="text" name="durata" size="30"
					value="<%=Durata%>" /></td>
			</tr>
			<tr>
				<td align="right">Rating:</td>
				<td><input type="text" name="rating" size="30"
					value="<%=Rating%>" /></td>
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