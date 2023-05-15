package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NarudzbaProizvod;
import ba.unsa.etf.rpr.domain.Proizvod;

import java.sql.*;
import java.util.List;

public class ProizvodDaoSQLImpl implements ProizvodDao {
    private Connection connection;

    public ProizvodDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_Baza/RPR/2022/2023", "freedb_nhelac1", "5C9@sNnN&W5UyAE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Proizvod getById(int id){
        return null;
    }

    @Override
    public Proizvod add(Proizvod item){
        return null;
    }

    @Override
    public Proizvod update(Proizvod item){
        return null;
    }

    @Override
    public void delete(int id){

    }

    @Override
    public List<Proizvod> getAll(){
        return null;
    }
}
