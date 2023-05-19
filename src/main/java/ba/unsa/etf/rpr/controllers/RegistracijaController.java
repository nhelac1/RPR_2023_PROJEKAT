package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistracijaController {
    public Button btnOtkazi, btnRegistracija;
    @FXML public TextField idIme, idPrezime, idAdresa, idEmail, idPassword;
    @FXML public Label idLabel5, idLabel6, idLabel7, idLabel8, idLabel9;


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
    public void actionRegistrujSe(ActionEvent actionEvent) {
        int brojac = 0;
        if (Objects.equals(idIme.getText(), "")) {
            idLabel5.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            idLabel5.setText("");
        }
        if (Objects.equals(idPrezime.getText(), "")) {
            idLabel6.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            idLabel6.setText("");
        }
        if (Objects.equals(idAdresa.getText(), "")) {
            idLabel7.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            idLabel7.setText("");
        }
        if (Objects.equals(idEmail.getText(), "")) {
            idLabel8.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            idLabel8.setText("");
        }
        if (Objects.equals(idPassword.getText(), "")) {
            idLabel9.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            idLabel9.setText("");
        }
        if (brojac == 0) {
            try {
                Stage stage = (Stage) btnRegistracija.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/potvrdaR.fxml"));
                fxmlLoader.setController(new PotvrdaRegistracijeController());
                Parent root = fxmlLoader.load();
                stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void actionOtkazi(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnOtkazi.getScene().getWindow();
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
