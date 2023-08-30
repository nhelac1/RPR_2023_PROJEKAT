package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;
/**
 * Sloj biznis logike za upravljanje narudzbama
 *
 * @author Nedzla
 */
public class NarudzbaManager {

    public Narudzba dodajNarudzbu(Narudzba n) throws CeraVeException {
        return DaoFactory.narudzbaDao().add(n);
    }

    public List<Narudzba> dajSveNarudzbe() throws CeraVeException {
        return DaoFactory.narudzbaDao().getAll();
    }
    public List<Narudzba> dajNarudzbuPoID(int id) throws CeraVeException {
        return DaoFactory.narudzbaDao().dajNarudzbuPoID(id);
    }


}
