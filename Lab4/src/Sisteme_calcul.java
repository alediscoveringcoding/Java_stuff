public class Sisteme_calcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private Sistemm sistem;

    public enum Sistemm {WINDOWS, LINUX}

    public Sisteme_calcul(String denumire, int nr_inventar, int pret, ZonaMag zonamag, Stare stare, String tip_mon, double vit_proc, int c_hdd, Sistemm sistem) {
        super(denumire, nr_inventar, pret, zonamag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    public String toString() {
        return  super.toString() + "Sisteme_calcul:" +
                "tip_mon: " + tip_mon +
                ", vit_proc: " + vit_proc +
                ", c_hdd " + c_hdd + '\'' +
                ", sistem " + sistem;
    }

    public Sistemm getSistem() {
        return sistem;
    }

    public void setSistem(Sistemm sistem) {
        this.sistem = sistem;
    }


}