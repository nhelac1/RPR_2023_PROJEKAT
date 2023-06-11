package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KategorijaManager;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.controllers.MojaKorpaController;
import ba.unsa.etf.rpr.controllers.ProizvodiController;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    Korisnik k1 = new Korisnik(1, "Nedžla", "Helać", "Zmaja od Bosne bb", "nedzlah@gmail.com", "12345678");
    Korisnik k2 = new Korisnik();
    Kategorija k3 = new Kategorija("Kreme za lice");
    Kategorija k4 = new Kategorija("Krema za lice");
    Kategorija k5 = new Kategorija(1, "Krema za lice");
    Proizvod p1 = new Proizvod(1, "Facial Moisturising Lotion", "Hidratantna krema za lice, 52ml", "28.20 KM", k3);
    Proizvod p2 = new Proizvod(7, "Facial Moisturising Lotion22", "Hidratantna krema za lice, 52ml", "28.20 KM", k5);

    @Test
    public void Test1() {
        assertAll(
                () -> assertEquals(1, k1.getId(), "ID je netačan!"),
                () -> assertEquals("Nedžla", k1.getIme(), "Ime je netačno!"),
                () -> assertEquals("Helać", k1.getPrezime(), "Prezime je netačno!"),
                () -> assertEquals("Zmaja od Bosne bb", k1.getAdresa(), "Adresa je netačna!"),
                () -> assertEquals("nedzlah@gmail.com", k1.getEmail(), "Email je netačan!"),
                () -> assertEquals("12345678", k1.getPassword(), "Password je netačan!")
        );
    }
    @Test
    public void Test2() {
        k2.setIme("Nejla");
        assertEquals("Nejla", k2.getIme());
        k2.setPrezime("Helać");
        assertEquals("Helać", k2.getPrezime());
        k2.setAdresa("Zmaja od Bosne bbb");
        assertEquals("Zmaja od Bosne bbb", k2.getAdresa());
        k2.setEmail("nejla@gmail.com");
        assertNotEquals("nejlaa@gmail.com", k2.getEmail());
        k2.setPassword("ababababab");
        assertNotEquals("babababa", k2.getPassword());
    }
    @Test
    public void Test3() {
        assertEquals(8, k1.getPassword().length(), "Password ne sadrži 8 znakova!");
    }
    @Test
    public void Test4() {
        assertEquals("Kreme za lice", k3.getIme());
        assertTrue(k3.equals(k4));

    }

    /*@Test
    public void Test5() throws CeraVeException {
        ProizvodManager proizvodManager = new ProizvodManager();

        assertAll(
                () -> assertTrue(proizvodManager.dajSveProizvode().contains(p1)),
                () -> assertEquals(p1, proizvodManager.dajProizvodPoID(1)),
                () -> assertEquals("Facial Moisturising Lotion22", proizvodManager.dodajProizvod(p2).getIme())

        );
    }*/

    @Test
    public void Test6(){
        Narudzba n1 = new Narudzba(1, "28.20 KM", k1);
        assertEquals(n1.getCijena(), p1.getCijena());
    }
    @Test
    public void Test7() throws CeraVeException {
        KategorijaManager kategorijaManager = new KategorijaManager();
        kategorijaManager.validacijaImenaKategorije("Kreme za lice");

        try {
            kategorijaManager.validacijaImenaKategorije("Lice");
        } catch (CeraVeException ce) {
            assertEquals("Dužina imena kategorije mora biti veća od 5 !", ce.getMessage());
        }
    }
    @Test
    public void Test8() {

    }
    @Test
    public void Test9() {

    }
    @Test
    public void Test10() {

    }
}
