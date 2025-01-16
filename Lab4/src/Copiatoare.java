public class Copiatoare extends Echipament{
    private int p_ton;
    private Format format;
    public enum Format{A3, A4}

    public Copiatoare(String denumire, int nr_inventar, int pret, ZonaMag zonamag, Stare stare, int p_ton, Format format) {
        super(denumire, nr_inventar, pret, zonamag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }
    //pentru setarea unui format de copiere
    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + "Copiatoare{" +
                "p_ton=" + p_ton +
                ", format=" + format +
                '}';
    }
}