package ba.unsa.etf.rpr.domain;

public class NarudzbaProizvod implements Idable{
    private int id;
    private Proizvod id_proizvod;
    private Narudzba id_narudzba;
    private String ime, cijena;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proizvod getProizvod() {
        return id_proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.id_proizvod = proizvod;
    }

    public Narudzba getNarudzba() {
        return id_narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.id_narudzba = narudzba;
    }

    public String getIme() {
        return id_proizvod.getIme();
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getCijena() {
        return id_narudzba.getCijena();
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }
}
