package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDaoSQLImpl extends AbstractDao<Proizvod> implements ProizvodDao {

    private static ProizvodDaoSQLImpl instance = null;

    public ProizvodDaoSQLImpl() {
        super("Proizvod");
    }
    /**
     *
     * @return KorisnikDAOSQLImpl
     * Za CRUD operacije (stvaranje, čitanje, ažuriranje i brisanje) nad tabelom "Proizvod" nije potrebno
     * više od jednog objekta, te zbog toga se koristi Singleton Pattern
     */
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

    @Override
    public List<Proizvod> pronadjiProizvod(String ime) throws CeraVeException {
        return executeQuery("SELECT * FROM Proizvod WHERE ime LIKE concat('%', ?, '%')", new Object[]{ime});
    }

    @Override
    public List<Proizvod> pronadjiProizvodPoKategoriji(Kategorija kat) throws CeraVeException {
        return executeQuery("SELECT * FROM Proizvod WHERE id_kategorija = ?", new Object[]{kat.getId()});
    }
}
