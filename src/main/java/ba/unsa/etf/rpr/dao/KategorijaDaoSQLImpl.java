package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * MySQL implementacija
 * @author Nedzla
 */
public class KategorijaDaoSQLImpl extends AbstractDao<Kategorija> implements KategorijaDao {
    private static KategorijaDaoSQLImpl instance = null;
    private KategorijaDaoSQLImpl() {
        super("Kategorija");
    }

    /**
     *
     * @return KorisnikDAOSQLImpl
     * Za CRUD operacije (stvaranje, čitanje, ažuriranje i brisanje) nad tabelom "Kategorija" nije potrebno
     * više od jednog objekta, te zbog toga se koristi Singleton Pattern
     */

    public static KategorijaDaoSQLImpl getInstance() {
        if (instance == null)
            instance = new KategorijaDaoSQLImpl();
        return instance;
    }
    public static void removeInstance() {
        if (instance != null)
            instance = null;
    }


    @Override
    public Kategorija row2object(ResultSet rs) throws CeraVeException {
        try {
            Kategorija kategorija = new Kategorija();
            kategorija.setId(rs.getInt("id"));
            kategorija.setIme(rs.getString("ime"));
            return kategorija;
        } catch (SQLException e) {
            throw new CeraVeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Kategorija object) {
        Map<String, Object> red = new TreeMap<>();
        red.put("id", object.getId());
        red.put("ime", object.getIme());
        return red;
    }

    /**
     * Metoda za pronalazak kategorije sa proslijedjenim imenom
     * @param ime
     * @return sve kategorije sa tim imenom
     * @throws CeraVeException
     */
    @Override
    public List<Kategorija> pronadjiKategorijuPoID(String ime) throws CeraVeException {
        return executeQuery("SELECT * FROM Kategorija WHERE ime = ?", new Object[]{ime});
    }
}
