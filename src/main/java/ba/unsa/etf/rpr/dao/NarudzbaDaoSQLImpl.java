package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.sql.*;
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
        String query = "SELECT * FROM Narudzba WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Narudzba order = new Narudzba();
                order.setId(rs.getInt("id"));
                order.setCijena(rs.getFloat("cijena"));
                rs.close();
                return order;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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
