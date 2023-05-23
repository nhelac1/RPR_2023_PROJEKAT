package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

public class NarudzbaManager {
    
    public Narudzba dodajNarudzbu(Narudzba n) throws CeraVeException {
        return DaoFactory.narudzbaDao().add(n);
    }
}
