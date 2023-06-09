package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;
/**
 * Sloj biznis logike za upravljanje narucenim proizvodima
 *
 * @author Nedzla
 */
public class NarudzbaProizvodManager {
    public NarudzbaProizvod dodajNP(NarudzbaProizvod np) throws CeraVeException {
        return DaoFactory.narProDao().add(np);
    }
    public List<NarudzbaProizvod> dajSveNP() throws CeraVeException {
        return DaoFactory.narProDao().getAll();
    }
    public List<NarudzbaProizvod> dajPoKorisniku(int id_korisnik) throws CeraVeException {
        return DaoFactory.narProDao().dajPoKorisniku(id_korisnik);
    }
}
