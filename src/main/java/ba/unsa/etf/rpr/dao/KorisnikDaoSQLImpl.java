package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Korisnik;

import java.sql.*;
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

        String query = "SELECT * FROM Korisnik WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Korisnik user = new Korisnik();
                user.setId(rs.getInt("id"));
                user.setIme(rs.getString("ime"));
                user.setPrezime(rs.getString("prezime"));
                user.setAdresa(rs.getString("adresa"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                rs.close();
                return user;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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
