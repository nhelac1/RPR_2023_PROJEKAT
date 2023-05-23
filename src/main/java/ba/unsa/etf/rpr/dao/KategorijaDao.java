package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

public interface KategorijaDao extends Dao<Kategorija> {
    List<Kategorija> pronadjiKategorijuPoID(String ime) throws CeraVeException;

}
