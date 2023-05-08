package ba.unsa.etf.rpr.domain;
import java.util.Objects;

public class Kategorija implements Idable{
    private int id;
    private String ime;

    public Kategorija(String ime) {
        this.ime = ime;
    }

    public Kategorija() {
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

    @Override
    public String toString() {
        return "Kategorija {" +
                "ime = '" + ime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija kategorija = (Kategorija) o;
        return id == kategorija.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime);
    }
}
