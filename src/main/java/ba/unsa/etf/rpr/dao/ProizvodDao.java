package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;
/**
 * DAO interfejs za objekat Proizvod
 *
 * @author Nedzla
 */
public interface ProizvodDao extends Dao<Proizvod> {
    List<Proizvod> pronadjiProizvod(String text) throws CeraVeException;
    List<Proizvod> pronadjiProizvodPoKategoriji(Kategorija kat) throws CeraVeException;
}
