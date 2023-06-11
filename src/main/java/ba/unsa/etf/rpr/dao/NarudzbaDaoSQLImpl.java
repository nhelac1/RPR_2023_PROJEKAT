package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;
/**
 * MySQL implementacija
 * @author Nedzla
 */
public class NarudzbaDaoSQLImpl extends AbstractDao<Narudzba> implements NarudzbaDao {
    private static NarudzbaDaoSQLImpl instance = null;
    public NarudzbaDaoSQLImpl() {
        super("Narudzba");
    }

    /**
     *
     * @return KorisnikDAOSQLImpl
     * Za CRUD operacije (stvaranje, čitanje, ažuriranje i brisanje) nad tabelom "Narudzba" nije potrebno
     * više od jednog objekta, te zbog toga se koristi Singleton Pattern
     */
    public static NarudzbaDaoSQLImpl getInstance()
    {
        if(instance == null)
            instance = new NarudzbaDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance != null)
            instance = null;
    }
    @Override
    public Narudzba row2object(ResultSet rs) throws CeraVeException {
        try {
            Narudzba narudzba = new Narudzba();
            narudzba.setId(rs.getInt("id"));
            narudzba.setCijena(rs.getString("cijena"));
            narudzba.setKorisnik(DaoFactory.korisnikDao().getById(rs.getInt("id_korisnik")));
            return narudzba;
        } catch (Exception e) {
            throw new CeraVeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Narudzba object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("cijena", object.getCijena());
        item.put("id_korisnik", object.getKorisnik().getId());
        return item;
    }
}