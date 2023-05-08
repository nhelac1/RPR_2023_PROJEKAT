package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Korisnik implements Idable {
    private int id;
    private String ime;
    private String prezime;
    private String adresa;
    private String email;
    private String password;

    public Korisnik(int id, String ime, String prezime, String adresa, String email, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.email = email;
        this.password = password;
    }

    public Korisnik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
