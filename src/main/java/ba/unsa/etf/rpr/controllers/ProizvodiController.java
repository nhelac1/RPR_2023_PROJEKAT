package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.domain.Proizvod;
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
    @FXML private TitledPane idKremeZaLice;
    @FXML private TableView<Proizvod> idPrikaz1, idPrikaz2, idPrikaz3;
    @FXML private TableColumn<Proizvod, String> idNaziv1, idNaziv2, idNaziv3;
    @FXML private TableColumn<Proizvod, String> idNamjena1, idNamjena2, idNamjena3;
    @FXML private TableColumn<Proizvod, String> idCijena1, idCijena2, idCijena3;
    private final ObservableList<Proizvod> data1 = FXCollections.observableArrayList();
    private final ObservableList<Proizvod> data2 = FXCollections.observableArrayList();
    private final ObservableList<Proizvod> data3 = FXCollections.observableArrayList();

    @FXML public void initialize() {
        idNaziv1.setCellValueFactory(new PropertyValueFactory<>("ime"));
        idNamjena1.setCellValueFactory(new PropertyValueFactory<>("namjena"));
        idCijena1.setCellValueFactory(new PropertyValueFactory<>("cijena"));

        Proizvod p = new Proizvod("Moistirusing Cream", "za suhe i ispucale ruke", "22 KM");
        data1.add(p);
        idPrikaz1.setItems(data1);


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
