package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.domain.Korisnik;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    Korisnik k1 = new Korisnik(1, "Nedžla", "Helać", "Zmaja od Bosne bb", "nedzlah@gmail.com", "12345678");

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

    }
    @Test
    public void Test3() {

    }
    @Test
    public void Test4() {

    }
    @Test
    public void Test5() {

    }
    @Test
    public void Test6() {

    }
    @Test
    public void Test7() {

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
