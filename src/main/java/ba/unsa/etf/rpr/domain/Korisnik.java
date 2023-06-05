package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Klasa za registrovane korisnike
 * @author Nedzla
 */
public class Korisnik implements Idable {
    private int id;
    private String ime;
    private String prezime;
    private String adresa;
    private String email;
    private String password;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param ime
     * @param prezime
     * @param adresa
     * @param email
     * @param password
     */
    public Korisnik(int id, String ime, String prezime, String adresa, String email, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.email = email;
        this.password = password;
    }

    /**
     * Konstruktor bez parametara
     */
    public Korisnik() {
    }

    /**
     * Getter i setter id-a korisnika
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter i setter imena korisnika
     */
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Getter i setter za prezime korisnika
     */
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Getter i setter za adresu korisnika
     */
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Getter i setter za email korisnika
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter i setter za password korisnika
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metoda za vraćanje stringa za ispis korisnika
     * @return string
     */
    @Override
    public String toString() {
        return "Korisnik {" +
                ", ime = '" + ime + '\'' +
                ", prezime = '" + prezime + '\'' +
                ", adresa = '" + adresa + '\'' +
                ", email = '" + email + '\'' +
                ", password = '" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return id == korisnik.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,ime,prezime,adresa,email,password);
    }
}
