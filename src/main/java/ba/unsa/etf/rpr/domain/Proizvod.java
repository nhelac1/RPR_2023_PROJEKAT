package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Proizvod implements Idable{
    private int id;
    private String slika;
    private String ime;
    private float cijena;

    public Proizvod(String slika, String ime, float cijena) {
        this.slika = slika;
        this.ime = ime;
        this.cijena = cijena;
    }

    public Proizvod() {
    }

    private Kategorija kategorija;

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

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }


    @Override
    public String toString() {
        return "Proizvod {" +
                "id = " + id +
                ", ime = '" + ime + '\'' +
                ", cijena = " + cijena +
                ", kategorija = " + kategorija +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvod proizvod = (Proizvod) o;
        return id == proizvod.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, ime, cijena, slika, kategorija);
    }
}
