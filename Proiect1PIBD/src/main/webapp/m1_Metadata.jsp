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
	String numefilm, duratafilm, ratingfilm, numecategorii, popularitatecategorii, taracategorii, an_de_lansare, limba;
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceMetadataId(aux);
	rs.first();
	int id1 = rs.getInt("idfilm_1");
	int id2 = rs.getInt("idcategorii_1");
	numefilm = rs.getString("numefilm");
	duratafilm = rs.getString("duratafilm");
	ratingfilm = rs.getString("ratingfilm");
	numecategorii = rs.getString("numecategorii");
	popularitatecategorii = rs.getString("popularitatecategorii");
	taracategorii = rs.getString("taracategorii");
	an_de_lansare = rs.getString("an_de_lansare");
	limba = rs.getString("limba");
	ResultSet rs1 = jb.vedeTabela("filme");
	ResultSet rs2 = jb.vedeTabela("categorii");
	int idfilme, idcategorie;
	%>
	<form action="m2_Metadata.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdMetadata:</td>
				<td><input type="text" name="idmetadata" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">idfilme:</td>
				<td><SELECT NAME="idfilme">
						<%
						while (rs1.next()) {
							idfilme = rs1.getInt("idfilme");
							numefilm = rs1.getString("nume");
							duratafilm = rs1.getString("durata");
							ratingfilm = rs1.getString("rating");
							if (idfilme != id1) {
						%>
						<OPTION VALUE="<%=idfilme%>"><%=idfilme%>,
							<%=numefilm%>,
							<%=duratafilm%>,
							<%=ratingfilm%></OPTION>
						<%
						} else {
						%>
						<OPTION selected="yes" VALUE="<%=idfilme%>"><%=idfilme%>,
							<%=numefilm%>,
							<%=duratafilm%>,
							<%=ratingfilm%></OPTION>
						<%
						}
						}
						%>
				</SELECT></td>
			</tr>
			<tr>
				<td align="right">idcategorii:</td>
				<td><SELECT NAME="idcategorii">
						<%
						while (rs2.next()) {
							idcategorie = rs2.getInt("idcategorii");
							numecategorii = rs2.getString("nume");
							popularitatecategorii = rs2.getString("popularitate");
							taracategorii = rs2.getString("tara");
							if (idcategorie != id2) {
						%>
						<OPTION VALUE="<%=idcategorie%>"><%=idcategorie%>,
							<%=numecategorii%>,
							<%=popularitatecategorii%>,
							<%=taracategorii%></OPTION>
						<%
						} else {
						%>
						<OPTION selected="yes" VALUE="<%=idcategorie%>"><%=idcategorie%>,
							<%=numecategorii%>,
							<%=popularitatecategorii%>,
							<%=taracategorii%></OPTION>
						<%
						}
						}
						%>
				</SELECT></td>
			</tr>
			<tr>
				<td align="right">An de Lansare:</td>
				<td><input type="text" name="an_de_lansare" size="30"
					value="<%=an_de_lansare%>" /></td>
			</tr>
			<tr>
				<td align="right">Limba:</td>
				<td><input type="text" name="limba" size="30"
					value="<%=limba%>" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="Modifica linia">
		</p>
	</form>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
<%
 rs.close();
 rs1.close();
 rs2.close();
 jb.disconnect();
 %>
</html>