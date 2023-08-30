package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.business.NarudzbaProizvodManager;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class NarudzbeController {

    @FXML private TableView<NarudzbaProizvod> idPrikazN;
    @FXML private TableColumn<NarudzbaProizvod, String> idNazivN;
    @FXML private TableColumn<NarudzbaProizvod, String> idCijenaN;
    private final NarudzbaManager narudzbaManager = new NarudzbaManager();
    private final NarudzbaProizvodManager narudzbaProizvodManager = new NarudzbaProizvodManager();
    private final KorisnikManager korisnikManager = new KorisnikManager();

    @FXML public void initialize() throws CeraVeException {
        System.out.println("radi i");
        idCijenaN.setCellValueFactory(new PropertyValueFactory<NarudzbaProizvod, String>("cijena"));
        idNazivN.setCellValueFactory(new PropertyValueFactory<NarudzbaProizvod, String>("ime"));
        prikaziNarudzbe();

    }

    void prikaziNarudzbe() throws CeraVeException {
        try {
            Model model = Model.getInstance();
            List<Korisnik> listaKorisnika = korisnikManager.dajSveKorisnike();
            List<NarudzbaProizvod> zadnjiRed = new ArrayList<>();
            List<NarudzbaProizvod> np = narudzbaProizvodManager.dajPoKorisniku(model.getKorisnik().getId());
            NarudzbaProizvod e = new NarudzbaProizvod();
            Proizvod p = new Proizvod();
            Narudzba n = new Narudzba();
            e.setProizvod(p);
            p.setIme("Total");
            e.setNarudzba(n);
            double suma = 0;
            for (NarudzbaProizvod n1 : np) {
                String cijena = n1.getNarudzba().getCijena();
                cijena = cijena.replace("KM", " ");
                double cijena1 = Double.parseDouble(cijena);
                suma += cijena1;

            }
            n.setCijena(String.format("%.2f KM", suma));

            np.add(e);

            idPrikazN.setItems(FXCollections.observableList(np));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
