package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
/**
 * DAO interfejs za objekat Korisnik
 *
 * @author Nedzla
 */
public interface KorisnikDao extends Dao<Korisnik> {
    Korisnik pronadjiEmail(String email) throws CeraVeException;
}
