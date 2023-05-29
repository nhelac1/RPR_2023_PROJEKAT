package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.business.KategorijaManager;
import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProizvodiController {
    public Button btnOdjava;
    @FXML private Accordion idKategorije;
    @FXML private TitledPane idKremeZaLice, idCistaciZaLice, idKremeZaTijelo;
    @FXML private TableView<Proizvod> idPrikaz1, idPrikaz2, idPrikaz3;
    @FXML private TableColumn<Proizvod, String> idNaziv1, idNaziv2, idNaziv3;
    @FXML private TableColumn<Proizvod, String> idNamjena1, idNamjena2, idNamjena3;
    @FXML private TableColumn<Proizvod, String> idCijena1, idCijena2, idCijena3;
    private final ObservableList<Proizvod> data1 = FXCollections.observableArrayList();
    private final ObservableList<Proizvod> data2 = FXCollections.observableArrayList();
    private final ObservableList<Proizvod> data3 = FXCollections.observableArrayList();

    private final ProizvodManager proizvodManager = new ProizvodManager();
    private final KategorijaManager kategorijaManager = new KategorijaManager();


    @FXML public void initialize() throws CeraVeException {
        idNaziv1.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("ime"));
        idNamjena1.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("namjena"));
        idCijena1.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("cijena"));

        idNaziv2.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("ime"));
        idNamjena2.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("namjena"));
        idCijena2.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("cijena"));

        idNaziv3.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("ime"));
        idNamjena3.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("namjena"));
        idCijena3.setCellValueFactory(new PropertyValueFactory<Proizvod, String>("cijena"));

        prikaziProizvode();

    }
    void prikaziProizvode() {
        try {
            List<Kategorija> listaKategorija =  kategorijaManager.dajSveKategorije();
            for (Kategorija kat : listaKategorija) {
                if (kat.getIme().equals("Kreme za lice")) {
                    System.out.println("radi1");
                    System.out.println(kat.getId());
                    idPrikaz1.setItems(FXCollections.observableList(proizvodManager.pronadjiProizvodPoKategoriji(kat)));
                    idPrikaz1.refresh();
                } else if (kat.getIme().equals("Cistaci za lice")) {
                    System.out.println("radi2");
                    System.out.println(kat.getId());
                    idPrikaz2.setItems(FXCollections.observableList(proizvodManager.pronadjiProizvodPoKategoriji(kat)));
                    idPrikaz2.refresh();
                } else if (kat.getIme().equals("Kreme za tijelo")) {
                    System.out.println("radi3");
                    System.out.println(kat.getId());
                    idPrikaz3.setItems(FXCollections.observableList(proizvodManager.pronadjiProizvodPoKategoriji(kat)));
                    idPrikaz3.refresh();
                }
            }

        }catch (CeraVeException e) {
            e.printStackTrace();
        }
    }
    public void actionOtvaranjeHelp(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/help.fxml"));
            HelpController help = new HelpController();
            fxmlLoader.setController(help);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Pomoć CeraVe");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionOtvaranjeONama(ActionEvent actionEvent) throws IOException {
        try {
            /*Stage stage =(Stage)btnONama.getScene().getWindow();
            stage.close();*/
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/obrendu.fxml"));
            OBrenduController brend = new OBrenduController();
            fxmlLoader.setController(brend);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("CeraVe");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionOdjaviSe(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage =(Stage)btnOdjava.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/pocetna.fxml"));
            PocetnaController pocetna = new PocetnaController();
            fxmlLoader.setController(pocetna);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Online CeraVe");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void actionOtvaranjeKorpe(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/korpa.fxml"));
            MojaKorpaController korpa = new MojaKorpaController();
            fxmlLoader.setController(korpa);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Moja CeraVe korpa");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void promjenaBoje(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(196,196,196); -fx-background-radius:10px;");
    }

    @FXML
    public void vracanjeBoje(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(223,223,223); -fx-background-radius: 10px;");
    }
    @FXML
    public void promjenaBoje1(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(128,188,255);");
    }
    @FXML
    public void vracanjeBoje1(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(36,140,255);");
    }

}
