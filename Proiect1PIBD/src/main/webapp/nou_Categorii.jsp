<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Categorii</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	String Nume = request.getParameter("nume");
	String Popularitate = request.getParameter("popularitate");
	String Tara = request.getParameter("tara");
	if (Nume != null) {
		jb.connect();
		jb.adaugaCategorie(Nume, Popularitate, Tara);
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	%>
	<h1>Suntem in tabela Categorii.</h1>
	<form action="nou_Categorii.jsp" method="post">
		<table>
			<tr>
				<td align="right">Nume Categorie:</td>
				<td><input type="text" name="nume" size="40" /></td>
			</tr>
			<tr>
				<td align="right">Popularitate:</td>
				<td><input type="text" name="popularitate" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Tara:</td>
				<td><input type="text" name="tara" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga categoria" />
	</form>
	<%
	}
	%>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>