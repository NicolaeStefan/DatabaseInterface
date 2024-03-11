<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Film</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	String Nume = request.getParameter("nume");
	String Durata = request.getParameter("durata");
	String Rating = request.getParameter("rating");
	if (Nume != null) {
		jb.connect();
		jb.adaugaFilm(Nume, Durata, Rating);
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	%>
	<h1>Adauga un nou film.</h1>
	<form action="nou_Film.jsp" method="post">
		<table>
			<tr>
				<td align="right">Nume Film:</td>
				<td><input type="text" name="nume" size="40" /></td>
			</tr>
			<tr>
				<td align="right">Durata Film:</td>
				<td><input type="text" name="durata" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Rating:</td>
				<td><input type="text" name="rating" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga filmul" />
	</form>
	<%
	}
	%>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>