package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

import java.util.List;

/**
 * Sloj biznis logike za upravljanje kategorijama
 *
 * @author Nedzla
 */
public class KategorijaManager {
    public void validacijaImenaKategorije(String ime) throws CeraVeException {
        if (ime == null || ime.length() < 5)
            throw new CeraVeException("Dužina imena kategorije mora biti veća od 5 !");

    }

    public Kategorija dodajKategoriju(Kategorija kat) throws CeraVeException{
        if (kat.getId() != 0)
            throw new CeraVeException("ID kategorije se automatski generiše !");
        validacijaImenaKategorije(kat.getIme());

        try {
            return DaoFactory.kategorijaDao().add(kat);
        } catch (CeraVeException e) {
            if (e.getMessage().contains("UQ_NAME"))
                throw new CeraVeException("Već postoji kategorija sa tim imenom !");
            throw e;
        }
    }

    public void obrisiKategoriju(int id_kategorija) throws CeraVeException {
        try {
            DaoFactory.kategorijaDao().delete(id_kategorija);
        } catch (CeraVeException e) {
            if (e.getMessage().contains("FOREIGN KEY"))
                    throw new CeraVeException("Ne možete obrisati kategoriju, jer je  u vezi sa tabelom Proizvod !");
        }
    }

    public Kategorija azurirajKategoriju(Kategorija kat) throws CeraVeException {
        validacijaImenaKategorije(kat.getIme());
        return DaoFactory.kategorijaDao().update(kat);
    }

    public List<Kategorija> dajSveKategorije() throws CeraVeException {
        return DaoFactory.kategorijaDao().getAll();
    }

    public List<Kategorija> pronadjiKategorijuPoID(String ime) throws CeraVeException{
        return DaoFactory.kategorijaDao().pronadjiKategorijuPoID(ime);
    }
}
