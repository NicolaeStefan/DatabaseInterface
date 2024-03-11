package PROIECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

	String error;
	 Connection con;
	 // Conectarea la baza de date
	 public DBOperations() {
	 }
	 
	 public void connect() throws ClassNotFoundException, SQLException, Exception {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projpibd?useSSL=false", 
						"root", "@lexandru1A");
			} catch (ClassNotFoundException cnfe) {
				error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
				throw new ClassNotFoundException(error);
			} catch (SQLException cnfe) {
				error = "SQLException: Nu se poate conecta la baza de date.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
				throw new Exception(error);
			}
		} 
		public void connect(String bd) throws ClassNotFoundException, SQLException, Exception {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, "root", 
						"@lexandru1A");
			} catch (ClassNotFoundException cnfe) {
				error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
				throw new ClassNotFoundException(error);
			} catch (SQLException cnfe) {
				error = "SQLException: Nu se poate conecta la baza de date.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
				throw new Exception(error);
			}
		} 
		public void connect(String bd, String ip) throws ClassNotFoundException, SQLException, 
		Exception {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + bd, "root", 
						"@lexandru1A");
			} catch (ClassNotFoundException cnfe) {
				error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
				throw new ClassNotFoundException(error);
			} catch (SQLException cnfe) {
				error = "SQLException: Nu se poate conecta la baza de date.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
				throw new Exception(error);
			}
		} 
		public void disconnect() throws SQLException {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
				throw new SQLException(error);
			}
		} 
		public void adaugaFilm(String Nume, String Durata, String Rating)
				throws SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					Statement stmt;
					stmt = con.createStatement();
					stmt.executeUpdate("insert into filme(nume, durata, rating) values('" + Nume
							+ "' , '" + Durata + "', '" + Rating + "');");
				} catch (SQLException sqle) {
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		} 
		
		public void adaugaMetadata(int idfilm, int idcategorie, String an, String limba )
						throws SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					Statement stmt;
					stmt = con.createStatement();
					stmt.executeUpdate(
							"insert into metadata(idfilme, idcategorii, an_de_lansare,"
							+ " limba) values('" + idfilm + "' , '" + idcategorie + "', '" + an + 
									"', '" + limba + "');");
				} catch (SQLException sqle) {
					
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}
		
		public ResultSet vedeTabela(String tabel) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String queryString = ("select * from `projpibd`.`" + tabel + "`;");
				Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
	ResultSet.CONCUR_READ_ONLY*/);
				rs = stmt.executeQuery(queryString);
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		}
		
		public ResultSet vedeMetadata() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String queryString = ("select a.nume numeF1, a.durata durataF1, a.rating ratingF1, "
						+ "b.nume numeC1, b.popularitate popularitateC1, b.tara taraC1, c.idmetadata, "
						+ "c.idcategorii idcategorii1, c.idfilme idfilme1, c.an_de_lansare, "
						+ "c.limba from filme a, categorii b, metadata c where a.idfilme = c.idfilme and b.idcategorii = c.idcategorii;");
						Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
	ResultSet.CONCUR_READ_ONLY*/);
						rs = stmt.executeQuery(queryString);
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		}
		
		public void stergeDateTabela(String primaryKeys, String tabela, String dupaID) throws
		SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					long aux;
					PreparedStatement delete;
					delete = con.prepareStatement("DELETE FROM " + tabela + " WHERE " + dupaID + "=?;");
					
						aux = java.lang.Long.parseLong(primaryKeys); 
						delete.setLong(1, aux);
						delete.execute();
					
				} catch (SQLException sqle) {
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				} catch (Exception e) {
					error = "A aparut o exceptie in timp ce erau sterse inregistrarile.";
					throw new Exception(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}
		
		public void stergeTabela(String tabela) throws SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					Statement stmt;
					stmt = con.createStatement();
					stmt.executeUpdate("delete from " + tabela + ";");
				} catch (SQLException sqle) {
					error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}
		
		public void modificaTabela(String tabela, String IDTabela, int ID, String[] campuri, String[] 
				valori) throws SQLException, Exception {
			String update = "update " + tabela + " set ";
			String temp = "";
			if (con != null) {
				try {
					for (int i = 0; i < campuri.length; i++) {
						if (i != (campuri.length - 1)) {
							temp = temp + campuri[i] + "='" + valori[i] + "', ";
						} else {
							temp = temp + campuri[i] + "='" + valori[i] + "' where " + IDTabela + " = '" + ID + "';";
						}
					}
					update = update + temp;
					// creaza un "prepared SQL statement"
					Statement stmt;
					stmt = con.createStatement();
					stmt.executeUpdate(update);
				} catch (SQLException sqle) {
					System.out.println(sqle);
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}
		
		public ResultSet intoarceLinie(String tabela, int ID) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT * FROM " + tabela + " where idfilme=" + ID + ";");
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		} 
		
		public ResultSet intoarceLinieDupaId(String tabela, String denumireId, int ID) throws
		SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT * FROM " + tabela + " where " + denumireId + "=" + ID
						+ ";");
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		} 
		
		public ResultSet intoarceMetadataId(int ID) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT a.nume numeF1, a.durata durataF1, a.rating ratingF1, "
						+ "b.nume numeC1, b.popularitate popularitateC1, b.tara taraC1, c.idmetadata, "
						+ "c.idcategorii idcategorii1, c.idfilme idfilme1, c.an_de_lansare, "
						+ "c.limba from filme a, categorii b, metadata c where a.idfilme = c.idfilme and b.idcategorii = c.idcategorii and idmetadata = '" + 
						ID + "';");
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		}

		public void adaugaCategorie(String Nume, String Popularitate, String Tara)
				throws SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					Statement stmt;
					stmt = con.createStatement();
					stmt.executeUpdate("insert into categorii(nume, popularitate, tara) values('" + Nume + 
							"' , '" + Popularitate + "', '" + Tara + "');");
				} catch (SQLException sqle) {
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}

	 
	 
}
