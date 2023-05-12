package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ba.unsa.etf.rpr.dao.KategorijaDao;
import ba.unsa.etf.rpr.dao.KategorijaDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.dao.KorisnikDao;
import ba.unsa.etf.rpr.dao.KorisnikDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.dao.NarudzbaDao;
import ba.unsa.etf.rpr.dao.NarudzbaDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.dao.NarudzbaProizvodDao;
import ba.unsa.etf.rpr.dao.NarudzbaProizvodDaoSQLImpl;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}