package PROIECT;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Categorii {
	
	private final IntegerProperty idcategorii;
	private final StringProperty nume;
	private final StringProperty popularitate;
	private final StringProperty tara;
	
	public Categorii(Integer idcategorii, String nume, String popularitate, String tara)
	{
		this.idcategorii = new SimpleIntegerProperty(idcategorii);
		this.nume = new SimpleStringProperty(nume);
		this.popularitate = new SimpleStringProperty(popularitate);
		this.tara = new SimpleStringProperty(tara);
		
	}
	
	public Integer getidcategorii() {
		return idcategorii.get();
	}
	
	public String getnume() {
		return nume.get();
	}
	
	public String getpopularitate() {
		return popularitate.get();		
	}
	
	public String gettara() {
		return tara.get();
	}
	
	public void setidcategorii(Integer val)
	{
		idcategorii.set(val);
	}
	
	public void setnume(String val) {
		nume.set(val);
	}
	
	public void setpopularitate(String val) {
		popularitate.set(val);
	}
	
	public void settara(String val) {
		tara.set(val);
	}
	
	public IntegerProperty idcategoriiProperty() {
		return idcategorii;
	}
	
	public StringProperty numeProperty() {
		return nume;
	}
	
	public StringProperty popularitateProperty() {
		return popularitate;
	}
	
	public StringProperty taraProperty() {
		return tara;
	}

}
