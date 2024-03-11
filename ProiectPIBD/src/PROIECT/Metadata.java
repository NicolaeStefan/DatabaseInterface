package PROIECT;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Metadata {
	
		private final IntegerProperty idmetadata;
		private final IntegerProperty idfilme1;
		private final IntegerProperty idcategorii1;
		private final StringProperty an_de_lansare;
		private final StringProperty limba;
		
		public Metadata(Integer idmetadata, Integer idfilme1,Integer idcategorii1,  String an_de_lansare, String limba )
		{
			this.idmetadata = new SimpleIntegerProperty(idmetadata);
			this.idfilme1 = new	SimpleIntegerProperty(idfilme1);
			this.idcategorii1 = new SimpleIntegerProperty(idcategorii1);
			this.an_de_lansare = new SimpleStringProperty(an_de_lansare);
			this.limba = new SimpleStringProperty(limba);
		}
		
		public Integer getidmetadata() {
			return idmetadata.get();
		}
		
		public Integer getidfilme1() {
			return idfilme1.get();
		}
		
		public Integer getidcategorii1() {
			return idcategorii1.get();
		}
		
		public final String getan() {
			return an_de_lansare.get();
		}
		
		public final String getlimba() {
			return limba.get();
		}
		
		
		public void setidmetadata(Integer val) {
			idmetadata.set(val);
		}
		
		public void setidfilme1(Integer val) {
			idfilme1.set(val);
		}
		
		public void setidcategorii1(Integer val) {
			idcategorii1.set(val);
		}
		
		public  void setan_de_lansare(String val) {
			an_de_lansare.set(val);
		}
		
		public  void setlimba(String val) {
			limba.set(val);
		}
		
		public IntegerProperty idmetadataProperty() {
			return idmetadata;
		}
		
		public IntegerProperty idfilme1Property() {
			return idfilme1;
		}
		
		public IntegerProperty idcategorii1Property() {
			return idcategorii1;
		}
		
		public  StringProperty an_de_lansareProperty() {
			return an_de_lansare;
		}
		
		public  StringProperty limbaProperty() {
			return limba;
		}
		
		
}
