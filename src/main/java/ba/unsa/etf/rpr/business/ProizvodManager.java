package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

public class ProizvodManager {
    public List<Proizvod> dajSveProizvode() throws CeraVeException {
        return DaoFactory.proizvodDao().getAll();
    }
}
