package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

public class KorisnikDaoSQLImpl extends AbstractDao<Korisnik> implements KorisnikDao {
    private static  KorisnikDaoSQLImpl instance = null;

    public KorisnikDaoSQLImpl() {
        super("Korisnik");
    }
    public static KorisnikDaoSQLImpl getInstance()
    {
        if(instance == null)
            instance = new KorisnikDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance != null)
            instance = null;
    }

    @Override
    public Korisnik row2object(ResultSet rs) throws CeraVeException {
        try {
            Korisnik korisnik = new Korisnik();
            korisnik.setId(rs.getInt("id"));
            korisnik.setIme(rs.getString("ime"));
            korisnik.setPrezime(rs.getString("prezime"));
            korisnik.setAdresa(rs.getString("adresa"));
            korisnik.setEmail(rs.getString("email"));
            korisnik.setPassword(rs.getString("password"));
            return korisnik;
        } catch (Exception e) {
            throw  new CeraVeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Korisnik object) {

        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("ime", object.getIme());
        item.put("prezime", object.getPrezime());
        item.put("adresa", object.getAdresa());
        item.put("email", object.getEmail());
        item.put("password", object.getPassword());
        return item;
    }
}
