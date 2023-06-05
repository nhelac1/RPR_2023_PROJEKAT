package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;
/**
 * DAO interfejs za objekat NarudzbaProizvod
 *
 * @author Nedzla
 */
public interface NarudzbaProizvodDao extends Dao<NarudzbaProizvod> {
    List<NarudzbaProizvod> dajPoKorisniku(int id_korisnik) throws CeraVeException;
}
