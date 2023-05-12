package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class NarudzbaProizvodDaoSQLImpl implements NarudzbaProizvodDao {
    private Connection connection;

    public NarudzbaProizvodDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_Baza/RPR/2022/2023", "freedb_nhelac1", "5C9@sNnN&W5UyAE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public NarudzbaProizvod getById(int id){
        return null;
    }

    @Override
    public NarudzbaProizvod add(NarudzbaProizvod item){
        return null;
    }

    @Override
    public NarudzbaProizvod update(NarudzbaProizvod item){
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<NarudzbaProizvod> getAll(){
        return null;
    }
}
