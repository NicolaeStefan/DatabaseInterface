<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Metadata</title>
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
	<form action="sterge_Metadata.jsp" method="post">
		<table border="1" align="center">
			<tr>
				<td><b>Mark:</b></td>
				<td><b>IdMetadata:</b></td>
				<td><b>IdFilm:</b></td>
				<td><b>NumeFilm:</b></td>
				<td><b>DurataFilm:</b></td>
				<td><b>RatingFilm:</b></td>
				<td><b>IdCategorii:</b></td>
				<td><b>NumeCategorii:</b></td>
				<td><b>PopularitateCategorii:</b></td>
				<td><b>TaraCategorii:</b></td>
				<td><b>An_de_lansare:</b></td>
				<td><b>Limba:</b></td>
			</tr>
			<%
			jb.connect();
			ResultSet rs = jb.vedeMetadata();
			long x;
			while (rs.next()) {
				x = rs.getInt("idmetadata");
			%>
			<tr>
				<td><input type="checkbox" name="primarykey" value="<%=x%>" /></td>
				<td><%=x%></td>
				<td><%=rs.getInt("idfilm_1")%></td>
				<td><%=rs.getString("numefilm")%></td>
				<td><%=rs.getString("duratafilm")%></td>
				<td><%=rs.getString("ratingfilm")%></td>
				<td><%=rs.getInt("idcategorii_1")%></td>
				<td><%=rs.getString("numecategorii")%></td>
				<td><%=rs.getString("popularitatecategorii")%></td>
				<td><%=rs.getString("taracategorii")%></td>
				<td><%=rs.getString("an_de_lansare")%></td>
				<td><%=rs.getString("limba")%></td>
				<%
				}
				%>
			</tr>
		</table>
		<br />
		<p align="center">
			<input type="submit" value="Sterge liniile marcate">
		</p>
	</form>
	<%
	rs.close();
	jb.disconnect();
	%>
	<br />
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
	</p>
</body>
</html>