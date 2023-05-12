package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Kategorija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class KategorijaDaoSQLImpl implements KategorijaDao {

    private Connection connection;

    public KategorijaDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_Baza/RPR/2022/2023", "freedb_nhelac1", "5C9@sNnN&W5UyAE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Kategorija getById(int id) {
        return null;
    }

    @Override
    public Kategorija add(Kategorija item) {
        return null;
    }

    @Override
    public Kategorija update(Kategorija item) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Kategorija> getAll() {
       return null;
    }

}
