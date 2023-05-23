package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDaoSQLImpl extends AbstractDao<Proizvod> implements ProizvodDao {

    private static ProizvodDaoSQLImpl instance = null;

    public ProizvodDaoSQLImpl() {
        super("Proizvod");
    }
    public static ProizvodDaoSQLImpl getInstance() {
        if(instance == null)
            instance = new ProizvodDaoSQLImpl();
        return instance;
    }

    public static void removeInstance() {
        if(instance != null)
            instance = null;
    }

    @Override
    public Proizvod row2object(ResultSet rs) throws CeraVeException {
        try {
            Proizvod proizvod = new Proizvod();
            proizvod.setId(rs.getInt("id"));
            proizvod.setIme(rs.getString("ime"));
            proizvod.setCijena(rs.getString("cijena"));
            proizvod.setNamjena(rs.getString("namjena"));
            proizvod.setKategorija(DaoFactory.kategorijaDao().getById(rs.getInt("id_kategorija")));
            return proizvod;
        } catch (Exception e) {
            throw new CeraVeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvod object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("ime", object.getIme());
        item.put("cijena", object.getCijena());
        item.put("namjena", object.getNamjena());
        item.put("id_kategorija", object.getKategorija().getId());
        return item;
    }
}
