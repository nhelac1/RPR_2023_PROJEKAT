package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final KategorijaDao kategorijaDao = KategorijaDaoSQLImpl.getInstance();
    private static final KorisnikDao korisnikDao = KorisnikDaoSQLImpl.getInstance();
}
