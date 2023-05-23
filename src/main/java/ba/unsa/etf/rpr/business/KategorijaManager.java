package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.CeraVeException;

public class KategorijaManager {
    public void validacijaImenaKategorije(String ime) throws CeraVeException {
        if (ime == null || ime.length() < 5)
            throw new CeraVeException("Dužina imena kategorije mora biti veća od 5 !");

    }

    
}
