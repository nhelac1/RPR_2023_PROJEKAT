package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

public class KorisnikManager {
    public static Korisnik pronadjiEmail(String email) throws CeraVeException {
        return DaoFactory.korisnikDao().pronadjiEmail(email);
    }
}
