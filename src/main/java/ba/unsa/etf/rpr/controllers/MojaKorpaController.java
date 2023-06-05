package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.HelloApplication;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.business.NarudzbaProizvodManager;
import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * JavaFX controller za kreiranje i izmjenu prozora korisnikove korpe
 *
 * @author Nedzla
 */
public class MojaKorpaController {
    public Button btnOdjava, btnZatvori, btnNaruci;
    public Label idLabel1, idLabel2, idLabel3, idLabel10;

    NarudzbaManager narudzbaManager = new NarudzbaManager();


    @FXML public void initialize() throws CeraVeException {
        if (ProizvodiController.selektovaniProizvod != null) {
            idLabel1.setText(ProizvodiController.selektovaniProizvod.getIme());
            idLabel2.setText(ProizvodiController.selektovaniProizvod.getCijena());
            idLabel10.setText(ProizvodiController.selektovaniProizvod.getNamjena());
        }

        /*Model model = Model.getInstance();
        System.out.println(model.getKorisnik().getIme());
        System.out.println(model.getProizvod().getCijena());*/
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

    /**
     * Događaj za odjavlivanje iz aplikacije, te mogućnosti ponovne prijave
     *
     * @param actionEvent
     */
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

    public void actionZatvori(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }

    /**
     * Događaj za brisanje dodanog proizvoda u korpu
     *
     * @param actionEvent
     */
    public void actionBrisanjeIzKorpe(ActionEvent actionEvent) {

        ProizvodiController.selektovaniProizvod = null;
        idLabel1.setText("");
        idLabel2.setText("");
        idLabel10.setText("");

    }

    /**
     * Metoda za bilježenje narudžbe ukoliko se korisnik odluči da neki proizvod poruči
     *
     */
    public void zabiljeziNarudzbu() throws CeraVeException {
        Model model = Model.getInstance();
        Narudzba narudzba = new Narudzba();
        NarudzbaProizvod srednja = new NarudzbaProizvod();

        narudzba.setKorisnik(model.getKorisnik());
        narudzba.setCijena(model.getProizvod().getCijena());
        narudzbaManager.dodajNarudzbu(narudzba);
        model.setNarudzba(narudzba);
        srednja.setNarudzba(model.getNarudzba());
        srednja.setProizvod(model.getProizvod());

        NarudzbaProizvodManager narProManager = new NarudzbaProizvodManager();
        narProManager.dodajNP(srednja);
    }
    public void actionNaruciProizvod(ActionEvent actionEvent) {

        if (idLabel1.getText() == "" && idLabel2.getText() == "" && idLabel10.getText() == "")
            idLabel3.setText("U korpi ne postoji nijedan proizvod za naručiti !");
        else {
            try {
                zabiljeziNarudzbu();
                Stage stage =(Stage)btnNaruci.getScene().getWindow();
                stage.close();
                Stage stage1 = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/potvrdaN.fxml"));
                PotvrdaNarudzbeController potvrda = new PotvrdaNarudzbeController();
                fxmlLoader.setController(potvrda);
                Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                stage1.setTitle("CeraVe");
                stage1.setScene(scene);
                stage1.setResizable(false);
                stage1.show();
            } catch (IOException | CeraVeException e) {
                System.out.println(e.getMessage());
            }
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
    @FXML
    public void promjenaBojeC(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(255,191,191); -fx-background-radius:10px;");
    }
    @FXML
    public void promjenaBojeZ(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgb(191,255,191); -fx-background-radius:10px;");
    }
}
