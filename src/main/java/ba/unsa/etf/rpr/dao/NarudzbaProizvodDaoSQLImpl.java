package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementacija
 * @author Nedzla
 */
public class NarudzbaProizvodDaoSQLImpl extends AbstractDao<NarudzbaProizvod> implements NarudzbaProizvodDao {

    private static NarudzbaProizvodDaoSQLImpl instance = null;
    public NarudzbaProizvodDaoSQLImpl() {
        super("NarudzbaProizvod");
    }


    public static NarudzbaProizvodDaoSQLImpl getInstance()
    {
        if(instance == null)
            instance = new NarudzbaProizvodDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance != null)
            instance = null;
    }

    @Override
    public NarudzbaProizvod row2object(ResultSet rs) throws CeraVeException {
        try {
            NarudzbaProizvod np = new NarudzbaProizvod();
            np.setId(rs.getInt("id"));
            np.setNarudzba(DaoFactory.narudzbaDao().getById(rs.getInt("id_narudzba")));
            np.setProizvod(DaoFactory.proizvodDao().getById(rs.getInt("id_proizvod")));
            return np;
        } catch (Exception e) {
            throw new CeraVeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(NarudzbaProizvod object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("id_narudzba", object.getNarudzba().getId());
        item.put("id_proizvod", object.getProizvod().getId());
        return item;
    }

    @Override
    public List<NarudzbaProizvod> dajPoKorisniku(int id_korisnik) throws CeraVeException {
        return executeQuery("SELECT NarudzbaProizvod.*\n" +
                "FROM NarudzbaProizvod\n" +
                "INNER JOIN Narudzba ON NarudzbaProizvod.id_narudzba = Narudzba.id\n" +
                "WHERE Narudzba.id_korisnik = ?",new Object[]{id_korisnik});
    }
}
