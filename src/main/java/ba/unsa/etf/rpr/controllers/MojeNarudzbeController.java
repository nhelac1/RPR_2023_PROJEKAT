package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class MojeNarudzbeController {
    public Button btnZatvori, btnDodaj;
    @FXML private TableColumn<Proizvod, String> idNaziv4, idNamjena4, idCijena4;
    @FXML private TabableView idPrikaz4;
    private Label proba;

    @FXML public void initialize(){
        System.out.println(MojaKorpaController.proizvodIzKorpe.getIme());
    }
    public void actionZatvori(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
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



}
