package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.*;

/**
 * Klasa za pohranjivanje trenutnog stanja aplikacije
 *
 * @author
 */
public class Model {
    private static Model instance;
    private Kategorija kategorija;
    private Korisnik korisnik;
    private Narudzba narudzba;
    private Proizvod proizvod;
    private NarudzbaProizvod narudzbaProizvod;

    public Model() {
    }

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public NarudzbaProizvod getNarudzbaProizvod() {
        return narudzbaProizvod;
    }

    public void setNarudzbaProizvod(NarudzbaProizvod narudzbaProizvod) {
        this.narudzbaProizvod = narudzbaProizvod;
    }
}
