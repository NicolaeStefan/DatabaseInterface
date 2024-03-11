package PROIECT;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PIBDPROJController implements Initializable{
	@FXML
	private TableView<Filme> tabela_Filme;
	 @FXML
	 private Tab tab_filme;
	 @FXML
	 private Button buton_IncarcareFilme;
	 @FXML
	 private TableColumn<Filme, Integer> atribut_idfilme;
	 @FXML
	 private TableColumn<Filme, String> atribut_numeF;
	 @FXML
	 private TableColumn<Filme, String> atribut_durataF;
	 @FXML
	 private TableColumn<Filme, String> atribut_ratingF;
	 @FXML
	 private TextField inputnumeF;
	 @FXML
	 private TextField inputdurataF;
	 @FXML
	 private TextField inputratingF;
	 @FXML
	 private TableView<Categorii> tabela_Categorii;
	 @FXML
	 private Tab tab_categorii;
	 @FXML
	 private Button buton_IncarcareCategorii;
	 @FXML
	 private TableColumn<Categorii, Integer> atribut_idcategorii;
	 @FXML
	 private TableColumn<Categorii, String> atribut_numeC;
	 @FXML
	 private TableColumn<Categorii, String> atribut_popularitateC;
	 @FXML
	 private TableColumn<Categorii, String> atribut_taraC;
	 @FXML
	 private TextField inputnumeC;
	 @FXML
	 private TextField inputpopularitateC;
	 @FXML
	 private TextField inputtaraC;
	 @FXML
	 private TableView<Metadata> tabela_Metadata;
	 @FXML
	 private Tab tab_metadata;
	 @FXML
	 private Button buton_IncarcareMetadata;
	 @FXML
	 private TableColumn<Metadata,Integer> atribut_idmetadata;
	 @FXML
	 private TableColumn<Metadata,Integer> atribut_idfilme1;
	 @FXML
	 private TableColumn<Metadata,Integer> atribut_idcategorii1;
	 @FXML
	 private TableColumn<Metadata,String> atribut_an;
	 @FXML
	 private TableColumn<Metadata,String> atribut_limba;
	 @FXML
	 private ComboBox combobox_filme;
	 @FXML
	 private ComboBox combobox_categorii;
	 @FXML
	 private TextField inputan;
	 @FXML
	 private TextField inputlimba;
	 
	 private static int mod;
	 private ObservableList<Filme> dateFilme;
	 private ObservableList<Categorii> dateCategorii;
	 private ObservableList<Metadata> dateMetadata;
	 private DBOperations jb;
	 
	 
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
		 if(combobox_filme != null) {
			 ObservableList<Integer>dateidFilme = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("filme");
				 while(rs.next()) {
					 dateidFilme.add(rs.getInt("idfilme"));
					 
				 }
				 jb.disconnect();
				 combobox_filme.setItems(dateidFilme);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(combobox_categorii != null) {
			 ObservableList<Integer>dateidCategorii = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("categorii");
				 while(rs.next()) {
					 dateidCategorii.add(rs.getInt("idcategorii"));
				 }
				 jb.disconnect();
				 combobox_categorii.setItems(dateidCategorii);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
	 } 
	 
	 @FXML
	 private void incarcaFilme() throws SQLException, Exception{
		 atribut_idfilme.setCellValueFactory(new PropertyValueFactory<>("idfilme"));
		 atribut_numeF.setCellValueFactory(new PropertyValueFactory<>("nume"));
		 atribut_durataF.setCellValueFactory(new PropertyValueFactory<>("durata"));
		 atribut_ratingF.setCellValueFactory(new PropertyValueFactory<>("rating"));
		 jb.connect();
		 dateFilme = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("filme");
		 while(rs.next()) {
			 dateFilme.add(new Filme(rs.getInt("idfilme"), rs.getString("nume"), rs.getString("durata"), rs.getString("rating")));
			 
		 }
		 jb.disconnect();
		 
		 tabela_Filme.setItems(null);
		 tabela_Filme.setItems(dateFilme);
	 }
	 
	 @FXML
	 private void startAdaugaFilme() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaFilme.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void adaugaFilme() throws SQLException, Exception{
		 String nume = inputnumeF.getText();
		 String durata = inputdurataF.getText();
		 String rating = inputratingF.getText();
		 
		 jb.connect();
		 jb.adaugaFilm(nume, durata, rating);
		 jb.disconnect();
		 
	 }
	 
	 @FXML
	 private void incarcaCategorie() throws SQLException, Exception{
		 jb.connect();
		 dateCategorii = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("categorii");
		 while(rs.next()) {
			 dateCategorii.add(new Categorii(rs.getInt("idcategorii"), rs.getString("nume"), rs.getString("popularitate"),rs.getString("tara")));
		 }
		 atribut_idcategorii.setCellValueFactory(new PropertyValueFactory<>("idcategorii"));
		 atribut_numeC.setCellValueFactory(new PropertyValueFactory<>("nume"));
		 atribut_popularitateC.setCellValueFactory(new PropertyValueFactory<>("popularitate"));
		 atribut_taraC.setCellValueFactory(new PropertyValueFactory<>("tara"));
		 
		 tabela_Categorii.setItems(null);
		 tabela_Categorii.setItems(dateCategorii);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaCategorii() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdaugaCategorii.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 @FXML
	 private void adaugaCategorii() throws SQLException, Exception{
		 String nume = inputnumeC.getText();
		 String popularitate = inputpopularitateC.getText();
		 String tara = inputtaraC.getText();
		 
		 jb.connect();
		 jb.adaugaCategorie(nume, popularitate, tara);
		 jb.disconnect();
		 
	 }
	 
	 @FXML
	 private void incarcaMetadata() throws SQLException, Exception{
		 jb.connect();
		 dateMetadata =FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeMetadata();
		 
		 while(rs.next()) {
			 dateMetadata.add(new Metadata(rs.getInt("idmetadata"),rs.getInt("idfilme1"), rs.getInt("idcategorii1"),
					 rs.getString("an_de_lansare"),rs.getString("limba")));
			 
		 }
		 atribut_idmetadata.setCellValueFactory(new PropertyValueFactory<>("idmetadata"));
		 atribut_idfilme1.setCellValueFactory(new PropertyValueFactory<>("idfilme1"));
		 atribut_idcategorii1.setCellValueFactory(new PropertyValueFactory<>("idcategorii1"));
		 atribut_an.setCellValueFactory(new PropertyValueFactory<>("an_de_lansare"));
		 atribut_limba.setCellValueFactory(new PropertyValueFactory<>("limba"));
		 
		 
		 tabela_Metadata.setItems(null);
		 tabela_Metadata.setItems(dateMetadata);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaMetadata() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaMetadata.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void adaugaMetadata() throws SQLException, Exception{
		 Integer idfilme = (Integer) combobox_filme.getValue();
		 Integer idcategorii = (Integer) combobox_categorii.getValue();
		 String an = inputan.getText();
		 String limba = inputlimba.getText();
		 
		 jb.connect();
		 jb.adaugaMetadata(idfilme, idcategorii, an, limba);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeFilme() throws SQLException, Exception{
		 
		 String  s = String.valueOf(dateFilme.get(tabela_Filme.getSelectionModel().getSelectedIndex()).getidfilme());
		 dateFilme.remove(tabela_Filme.getSelectionModel().getSelectedIndex());
		 
		 jb.connect();
		 jb.stergeDateTabela(s, "filme", "idfilme");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeCategorie() throws SQLException, Exception{
		 String s = String.valueOf(dateCategorii.get(tabela_Categorii.getSelectionModel().getSelectedIndex()).getidcategorii());
		 dateCategorii.remove(tabela_Categorii.getSelectionModel().getSelectedIndex());
		 
		 jb.connect();
		 jb.stergeDateTabela(s, "categorii", "idcategorii");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeMetadata() throws SQLException, Exception{
		 String s = String.valueOf(dateMetadata.get(tabela_Metadata.getSelectionModel().getSelectedIndex()).getidmetadata());
		 dateMetadata.remove(tabela_Metadata.getSelectionModel().getSelectedIndex());
		 
		 jb.connect();
		 jb.stergeDateTabela(s, "metadata", "idmetadata");
		 jb.disconnect();
	 }
	 @FXML
	 private void startModificaFilme() throws IOException{
		  mod = dateFilme.get(tabela_Filme.getSelectionModel().getSelectedIndex()).getidfilme();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaFilme.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void modificaFilme() throws SQLException, Exception{
		 
		 String nume = inputnumeF.getText();
		 String durata =inputdurataF.getText();
		 String rating = inputratingF.getText();
		 String [] valori = {nume, durata, rating};
		 String [] campuri = {"nume", "durata" , "rating"};
		 jb.connect();
		 jb.modificaTabela("filme", "idfilme", mod, campuri, valori);
		 jb.disconnect();
		 
	 }
	 
	 @FXML
	 private void startModificaCategorii() throws IOException{
		 mod = dateCategorii.get(tabela_Categorii.getSelectionModel().getSelectedIndex()).getidcategorii();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaCategorie.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void startModificaMetadata() throws IOException{
		 mod = dateMetadata.get(tabela_Metadata.getSelectionModel().getSelectedIndex()).getidmetadata();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaMetadata.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void modificaCategorii() throws SQLException, Exception{
		 
	 }
	 
	 
	 
}
