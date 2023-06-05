package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * JavaFX controller za kreiranje i izmjenu prozora koji se otvori kada se aplikacija pokrene
 *
 * @author Nedzla
 */
public class PocetnaController {
    public Button btnRegistracija, btnPrijava;
    public TextField idEmail;
    public PasswordField idPassword;
    public Label idLabel4;
    KorisnikManager korisnikManager = new KorisnikManager();

    public void actionPrijava(ActionEvent actionEvent) throws CeraVeException {
        String uneseniEmail = idEmail.getText();
        String uneseniPassword = idPassword.getText();
        List<Korisnik> listaPrijavljenihKorisnika = korisnikManager.dajSveKorisnike();
        Model modelKorisnik = Model.getInstance();
        int brojac = 0, brojac1 = 0;

        if (Objects.equals(idPassword.getText(), "") || Objects.equals(idEmail.getText(), "")) {
            idLabel4.setText("Polje ne može biti prazno !");
            brojac++;
        } else {
            for (Korisnik k : listaPrijavljenihKorisnika) {
                if (k.getEmail().equals(uneseniEmail) && k.getPassword().equals(uneseniPassword)) {
                    brojac1++;
                    modelKorisnik.setKorisnik(k);
                }
            }
            if (brojac1 != 0)
                idLabel4.setText("");
            else
                idLabel4.setText("Neispravni uneseni podaci!");
        }

        if (brojac == 0 && brojac1 != 0) {
            try {

                Stage stage =(Stage)btnPrijava.getScene().getWindow();
                stage.close();
                Stage stage1 = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/proizvodi.fxml"));
                ProizvodiController proizvodi = new ProizvodiController();
                fxmlLoader.setController(proizvodi);
                Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                stage1.setTitle("CeraVe ponuda");
                stage1.setScene(scene);
                stage1.setResizable(false);
                stage1.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Otvaranje prozora za registraciju ukoliko korisnik nema račun na aplikaciji
     * @param actionEvent
     * @throws IOException
     */
    public void actionRegistracija(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage =(Stage)btnRegistracija.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/registracija.fxml"));
            RegistracijaController reg = new RegistracijaController();
            fxmlLoader.setController(reg);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Registracija CeraVe");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Događaj za otvaranje prozora za pomoć
     *
     * @param actionEvent
     */
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

    /**
     * Događaj za otvaranje prozora za više informacija
     *
     * @param actionEvent
     */
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
