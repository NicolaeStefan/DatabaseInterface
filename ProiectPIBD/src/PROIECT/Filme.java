package PROIECT;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Filme {
	private final IntegerProperty idfilme;
	private final StringProperty nume;
	private final StringProperty durata;
	private final StringProperty rating;
	
	public Filme(Integer idfilme, String nume, String durata, String rating)
	{
		this.idfilme = new SimpleIntegerProperty(idfilme);
		this.nume = new SimpleStringProperty(nume);
		this.durata = new SimpleStringProperty(durata);
		this.rating = new SimpleStringProperty(rating);
	}
	
	public  Integer getidfilme() {
		return idfilme.get();
	}
	
	public String getnume() {
		return nume.get();
	}
	
	public String getdurata() {
		return durata.get();
	}
	
	public String getrating() {
		return rating.get();
	}
	
	public void setidfilme(Integer val) {
		idfilme.set(val);
	}
	
	public void setnume(String val) {
		nume.set(val);
	}
	
	public void setdurata(String val) {
		durata.set(val);
	}
	
	public void setrating(String val) {
		rating.set(val);
	}
	
	public IntegerProperty idfilmeProperty() {
		return idfilme;
	}
	
	public StringProperty numeProperty() {
		return nume;
	}
	
	public StringProperty durataProperty() {
		return durata;
	}
	
	public StringProperty ratingProperty() {
		return rating;
	}
	
	

}
