package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Narudzba implements Idable{
    private int id;
    private float cijena;
    private Korisnik korisnik;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "Narudzba {" +
                "id = " + id +
                ", cijena = " + cijena +
                ", korisnik = " + korisnik +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Narudzba narudzba = (Narudzba) o;
        return id == narudzba.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cijena, korisnik);
    }

}
