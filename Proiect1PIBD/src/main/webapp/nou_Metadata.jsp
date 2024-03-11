<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Metadata.</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	int idfilme, idcategorii;
	String id1, id2, numefilm, duratafilm, ratingfilm, numecategorii, popularitatecategorii, taracategorii, an_de_lansare, limba;
	id1 = request.getParameter("idfilme");
	id2 = request.getParameter("idcategorii");	
	an_de_lansare = request.getParameter("an_de_lansare");
	limba = request.getParameter("limba");
	if (id1 != null) {
		jb.connect();
		jb.adaugaMetadata(java.lang.Integer.parseInt(id1), java.lang.Integer.parseInt(id2), an_de_lansare, limba);
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	jb.connect();
	ResultSet rs1 = jb.vedeTabela("filme");
	ResultSet rs2 = jb.vedeTabela("categorii");
	%>
	<h1>Adaugare Metadata</h1>
	<form action="nou_Metadata.jsp" method="post">
		<table>
			<tr>
				<td align="right">IdFilme:</td>
				<td>Selectati filmul: <SELECT NAME="idfilme">
						<%
						while (rs1.next()) {
							idfilme = rs1.getInt("idfilme");
							numefilm = rs1.getString("nume");
							duratafilm = rs1.getString("durata");
							ratingfilm = rs1.getString("rating");
						%>
						<OPTION VALUE="<%=idfilme%>"><%=idfilme%>,<%=numefilm%>,<%=duratafilm%>,<%=ratingfilm%></OPTION>
						<%
						}
						%>
				</SELECT>

				</td>
			</tr>
			<tr>
				<td align="right">IdCategorie:</td>
				<td>Selectati categoria: <SELECT NAME="idcategorii">
						<!-- OPTION selected="yes" VALUE="iris1">Iris 1</OPTION -->
						<%
						while (rs2.next()) {
							idcategorii = rs2.getInt("idcategorii");
							numecategorii = rs2.getString("nume");
							popularitatecategorii = rs2.getString("popularitate");
							taracategorii = rs2.getString("tara");
						%>
						<OPTION VALUE="<%=idcategorii%>"><%=idcategorii%>,<%=numecategorii%>,<%=popularitatecategorii%>,<%=taracategorii%></OPTION>
						<%
						}
						%>
				</SELECT>
				</td>
			</tr>
			<tr>
				<td align="right">An De Lansare:</td>
				<td><input type="text" name="an_de_lansare" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Limba:</td>
				<td><input type="text" name="limba" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga metadata" />
	</form>
	<%
 }
 %>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>