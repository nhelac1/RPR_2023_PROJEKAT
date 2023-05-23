package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

public interface ProizvodDao extends Dao<Proizvod> {
    List<Proizvod> pronadjiProizvod(String text) throws CeraVeException;
}
