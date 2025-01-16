public class Echipament {
    private String denumire;
    private int nr_inventar;
    private int pret;
    private ZonaMag zonamag;
    private Stare stare;

    public void setFormat(Copiatoare.Format format) {
    }

    public void setSistem(Sisteme_calcul.Sistemm sistemNou) {
    }

    public enum ZonaMag {A, B, C}

    public enum Stare {ACHIZITIONAT, EXPUS, VANDUT}

    public Echipament(String denumire, int nr_inventar, int pret, ZonaMag zonamag, Stare stare) {
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.zonamag = zonamag;
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inventar=" + nr_inventar +
                ", pret=" + pret +
                ", zonamag=" + zonamag +
                ", stare=" + stare +
                '}';
    }

    public Stare getStare(){
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }
}