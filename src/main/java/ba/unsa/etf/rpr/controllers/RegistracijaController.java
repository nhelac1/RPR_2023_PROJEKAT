package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import ba.unsa.etf.rpr.business.KorisnikManager;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistracijaController {

    public Button btnOtkazi, btnRegistracija;
    @FXML public TextField idIme, idPrezime, idAdresa, idEmail;
    public PasswordField idPassword;
    @FXML public Label idLabel5, idLabel6, idLabel7, idLabel8, idLabel9;
    KorisnikManager korisnikManager = new KorisnikManager();

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
    public void actionRegistrujSe(ActionEvent actionEvent) throws CeraVeException {
        List<Korisnik> listaRegKorisnika = korisnikManager.dajSveKorisnike();

        String unesenoIme = idIme.getText();
        String unesenoPrezime = idPrezime.getText();
        String unesenaAdresa = idAdresa.getText();
        String uneseniEmail = idEmail.getText();
        String uneseniPassword = idPassword.getText();

        int brojac = 0, brojac1 = 0;
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
            for (Korisnik k : listaRegKorisnika) {
                if (k.getEmail().equals(idEmail.getText())) {
                    brojac++; //ako postoji vec isti email
                    brojac1++;
                    idLabel8.setText("Korisnik sa tim emailom već postoji !");
                }
            }
            if (brojac1 == 0)
                idLabel8.setText("");
        }


        if (Objects.equals(idPassword.getText(), "")) {
            idLabel9.setText("Polje ne može biti prazno !");
            brojac++;
        } else if (idPassword.getText().length() < 8) {
            idLabel9.setText("Password mora sadržavati 8 karaktera !");
            brojac++;
        }
        else {
            idLabel9.setText("");
        }

        /*if(brojac == 0) {
            for (Korisnik k : listaRegKorisnika) {
                if (k.getEmail().equals(idEmail.getText()))
                    brojac1++; //ako postoji vec isti email
                    idLabel8.setText("Korisnik sa tim emailom već postoji !");
            }
        }*/

        if (brojac == 0 && brojac1 == 0) {
            Korisnik k = new Korisnik();
            k.setIme(unesenoIme);
            k.setPrezime(unesenoPrezime);
            k.setAdresa(unesenaAdresa);
            k.setEmail(uneseniEmail);
            k.setPassword(uneseniPassword);

            try {
                FileReader r = new FileReader("src/main/resources/database.properties");
                Properties p = new Properties();
                p.load(r);
                String string1 = p.getProperty("db.server");
                String string2 = p.getProperty("db.username");
                String string3 = p.getProperty("db.password");

                Connection connection = DriverManager.getConnection(string1, string2, string3);
                System.out.println(string1 + " " + string2 + " " + string3);

                Korisnik noviK = korisnikManager.dodajKorisnika(k);

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
                connection.close();

            }catch (Exception e) {
                e.printStackTrace();
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
