package ba.unsa.etf.rpr.dao;

public class DaoFactory {

    private DaoFactory(){}



    private static final KategorijaDao kategorijaDao = KategorijaDaoSQLImpl.getInstance();

    public static KategorijaDao kategorijaDao() {
        return kategorijaDao;
    }



    private static final KorisnikDao korisnikDao = KorisnikDaoSQLImpl.getInstance();

    public static KorisnikDao korisnikDao() {
        return korisnikDao;
    }
}
