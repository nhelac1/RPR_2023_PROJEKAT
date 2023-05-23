package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

public class NarudzbaProizvodManager {
    public NarudzbaProizvod dodajNP(NarudzbaProizvod np) throws CeraVeException {
        return DaoFactory.narProDao().add(np);
    }
    public List<NarudzbaProizvod> dajSveNP() throws CeraVeException {
        return DaoFactory.narProDao().getAll();
    }
}
