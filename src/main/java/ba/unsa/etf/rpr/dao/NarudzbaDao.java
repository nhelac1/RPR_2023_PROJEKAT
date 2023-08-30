package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

/**
 * DAO interfejs za objekat Narudzba
 *
 * @author Nedzla
 */
public interface NarudzbaDao extends Dao<Narudzba> {
    List<Narudzba> dajNarudzbuPoID(int id) throws CeraVeException;

}
