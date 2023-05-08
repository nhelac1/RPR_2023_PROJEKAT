package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Proizvod implements Idable{
    private int id;
    private String ime;
    private float cijena;
    private int kolicina;
    private String opis;
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

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
                ", kolicina = " + kolicina +
                ", opis = '" + opis + '\'' +
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
        return Objects.hash(id, ime, cijena, kolicina, opis, kategorija);
    }
}
