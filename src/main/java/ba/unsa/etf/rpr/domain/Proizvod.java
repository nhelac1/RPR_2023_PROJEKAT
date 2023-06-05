package ba.unsa.etf.rpr.domain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public class Proizvod implements Idable{
    private int id;
    private String ime;
    private String namjena;
    private String cijena;
    private Kategorija kategorija;

    public Proizvod(int id, String ime, String namjena, String cijena) {
        this.id = id;
        this.ime = ime;
        this.namjena = namjena;
        this.cijena = cijena;
    }

    public Proizvod(int id, String ime, String namjena, String cijena, Kategorija kategorija) {
        this.id = id;
        this.ime = ime;
        this.namjena = namjena;
        this.cijena = cijena;
        this.kategorija = kategorija;
    }

    public Proizvod() {
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

    public String getNamjena() {
        return namjena;
    }

    public void setNamjena(String namjena) {
        this.namjena = namjena;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
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
                ", namjena = '" + namjena + '\'' +
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
        return Objects.hash(id, ime, namjena, cijena, kategorija);
    }
}
