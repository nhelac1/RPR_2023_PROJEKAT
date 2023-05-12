package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Kategorija;

import java.sql.*;
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
        String query = "SELECT * FROM Kategorija WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Kategorija category = new Kategorija();
                category.setId(rs.getInt("id"));
                category.setIme(rs.getString("ime"));
                rs.close();
                return category;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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
