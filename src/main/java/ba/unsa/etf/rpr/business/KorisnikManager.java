package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

public class KorisnikManager {

    public static Korisnik pronadjiEmail(String email) throws CeraVeException {
        return DaoFactory.korisnikDao().pronadjiEmail(email);
    }

    public void obrisiKorisnika(int id_korisnik) throws CeraVeException {
        try {
            DaoFactory.korisnikDao().delete(id_korisnik);
        } catch (CeraVeException e) {
            if (e.getMessage().contains("FOREIGN KEY")) {
                throw new CeraVeException("Ne možete obrisati korisnika, jer je u vezi sa tabelom Narudžba !");
            }
            throw e;
        }
    }

    public static Korisnik dodajKorisnika(Korisnik k) throws CeraVeException {
        return DaoFactory.korisnikDao().add(k);
    }

    public Korisnik pronadjiKorisnikaPoID(int id) throws CeraVeException {
        return DaoFactory.korisnikDao().getById(id);
    }

    public Korisnik azurirajKorisnika(Korisnik k) throws CeraVeException {
        return DaoFactory.korisnikDao().update(k);
    }

    public List<Korisnik> dajSveKorisnike() throws CeraVeException {
        return DaoFactory.korisnikDao().getAll();
    }
}
