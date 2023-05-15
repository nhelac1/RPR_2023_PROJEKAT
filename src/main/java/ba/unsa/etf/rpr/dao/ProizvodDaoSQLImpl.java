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
        String query = "SELECT * FROM Proizvod WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Proizvod product = new Proizvod();
                product.setId(rs.getInt("id"));
                product.setIme(rs.getString("ime"));
                product.setCijena(rs.getFloat("cijena"));
                product.setKolicina(rs.getInt("kolicina"));
                product.setOpis(rs.getString("opis"));
                product.setSlika(rs.getBytes("slika"));
                rs.close();
                return product;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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
