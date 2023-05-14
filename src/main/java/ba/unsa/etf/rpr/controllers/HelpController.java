package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HelpController {
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
