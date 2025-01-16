public class Imprimante extends Echipament {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private ModTiparire tiparire;
    public enum ModTiparire{COLOR,ALB_NEGRU}

    public Imprimante(String denumire, int nr_inventar, int pret, Echipament.ZonaMag zonamag, Echipament.Stare stare, int ppm, String rezolutie, int p_car, ModTiparire tiparire) {
        super(denumire,nr_inventar,pret,zonamag,stare);
        this.ppm= ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    @Override
    public String toString() {
        return super.toString() + "Imprimante{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", tiparire=" + tiparire +
                '}';
    }
}