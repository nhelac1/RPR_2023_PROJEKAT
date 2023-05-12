package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class NarudzbaDaoSQLImpl implements NarudzbaDao {

    private Connection connection;

    public NarudzbaDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_Baza/RPR/2022/2023", "freedb_nhelac1", "5C9@sNnN&W5UyAE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Narudzba getById(int id) {
        return null;
    }

    @Override
    public Narudzba add(Narudzba item){
        return null;
    }

    @Override
    public Narudzba update(Narudzba item)  {
        return null;
    }

    @Override
    public void delete(int id){

    }

    @Override
    public List<Narudzba> getAll(){
        return null;
    }
}
