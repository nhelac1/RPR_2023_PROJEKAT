package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class PotvrdaNarudzbeController {
    public Button btnZatvori;
    public Label idLabel11;

    @FXML public void initialize() throws CeraVeException {
        Model model = Model.getInstance();
        idLabel11.setText("Hvala, " + model.getKorisnik().getIme() + " " + model.getKorisnik().getPrezime() + "!");
    }
    public void actionZatvori(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void promjenaBoje(MouseEvent event) {
        javafx.scene.control.Button btn = (javafx.scene.control.Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(196,196,196); -fx-background-radius:10px;");
    }

    @FXML
    public void vracanjeBoje(MouseEvent event) {
        javafx.scene.control.Button btn = (javafx.scene.control.Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(223,223,223); -fx-background-radius: 10px;");
    }
}
