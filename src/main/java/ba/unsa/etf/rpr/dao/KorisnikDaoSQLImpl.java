package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class KorisnikDaoSQLImpl implements KorisnikDao {
    private Connection connection;

    public KorisnikDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_Baza/RPR/2022/2023", "freedb_nhelac1", "5C9@sNnN&W5UyAE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public Korisnik getById(int id){
        return null;
    }

    @Override
    public Korisnik add(Korisnik item)  {
        return null;
    }

    @Override
    public Korisnik update(Korisnik item)  {
        return null;
    }

    @Override
    public void delete(int id){

    }

    @Override
    public List<Korisnik> getAll() {
        return null;
    }
}
