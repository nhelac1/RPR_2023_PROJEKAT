package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class KategorijaDaoSQLImpl extends AbstractDao<Kategorija> implements KategorijaDao {
    private static KategorijaDaoSQLImpl instance = null;
    private KategorijaDaoSQLImpl() {
        super("Kategorija");
    }

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
}
