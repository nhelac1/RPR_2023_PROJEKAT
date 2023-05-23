package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

public class ProizvodManager {
    public List<Proizvod> dajSveProizvode() throws CeraVeException {
        return DaoFactory.proizvodDao().getAll();
    }

    public List<Proizvod> pronadjiProizvod(String ime) throws CeraVeException {
        return DaoFactory.proizvodDao().pronadjiProizvod(ime);
    }

    public void obrisiProizvod(int id) throws CeraVeException {
        DaoFactory.proizvodDao().delete(id);
    }

    public Proizvod dajProizvodPoID(int id) throws CeraVeException {
        return DaoFactory.proizvodDao().getById(id);
    }

    public void azurirajProizvod(Proizvod p) throws CeraVeException {
        DaoFactory.proizvodDao().update(p);
    }
}
