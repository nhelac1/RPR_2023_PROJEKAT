package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;

public class DaoFactory {

    private DaoFactory(){}

    private static final KategorijaDao kategorijaDao = KategorijaDaoSQLImpl.getInstance();
    public static KategorijaDao kategorijaDao() { return kategorijaDao; }

    private static final KorisnikDao korisnikDao = KorisnikDaoSQLImpl.getInstance();
    public static KorisnikDao korisnikDao() {
        return korisnikDao;
    }

    private static final NarudzbaDao narudzbaDao = NarudzbaDaoSQLImpl.getInstance();
    public static NarudzbaDao narudzbaDao() {
        return narudzbaDao;
    }

    private static final ProizvodDao proizvodDao = ProizvodDaoSQLImpl.getInstance();
    public static ProizvodDao proizvodDao() { return proizvodDao; }
}
