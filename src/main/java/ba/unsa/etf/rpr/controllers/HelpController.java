package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
/**
 * JavaFX controller za kreiranje i izmjenu prozora za pomoć korisniku
 *
 * @author Nedzla
 */
public class HelpController {
    public Button btnZatvori, btnONama;

    public void actionOtvaranjeONama(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage =(Stage)btnONama.getScene().getWindow();
            stage.close();
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
    /**
     * Događaj za zatvaranje prozora
     *
     * @param actionEvent
     */
    public void actionZatvori(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }

    /**
     * Događaj za promjenu boje prelaskom miša preko button-a
     *
     * @param event
     */
    @FXML
    public void promjenaBoje(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(196,196,196); -fx-background-radius:10px;");
    }
    /**
     * Događaj za vraćanje stare boje button-a kada miš nije na button-u
     *
     * @param event
     */
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
