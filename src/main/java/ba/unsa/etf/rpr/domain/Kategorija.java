package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * Klasa za kategorije proizvoda
 * @author Nedzla
 */
public class Kategorija implements Idable{
    private int id;
    private String ime;

    /**
     * Konstruktor sa jednim parametrom
     * @param ime
     */
    public Kategorija(String ime) {
        this.ime = ime;
    }

    /**
     * Konstruktor sa dva parametra
     * @param id
     * @param ime
     */
    public Kategorija(int id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    /**
     * Konstruktor bez parametara
     */
    public Kategorija() {
    }

    /**
     * Vracanje id-a
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Postavljanje id-a
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Vracanje imena kategorija
     * @return ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavljanje imena kategorije
     * @param ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Ispis kategorije
     * @return string sa podacima kategorije
     */
    @Override
    public String toString() {
        return "Kategorija {" +
                "ime = '" + ime + '\'' +
                '}';
    }

    /**
     * Poredjenje dvije kategorije
     * @param o - kategorija sa kojom se poredi
     * @return true ili false
     */
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
