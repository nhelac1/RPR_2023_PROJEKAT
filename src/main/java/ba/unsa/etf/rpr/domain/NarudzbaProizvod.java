package ba.unsa.etf.rpr.domain;

public class NarudzbaProizvod implements Idable{
    private int id;
    private Proizvod proizvod;
    private Narudzba narudzba;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }
}
