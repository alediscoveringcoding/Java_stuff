package ex1;

public class Parabola {
    private int a;
    private int b;
    private int c;


    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int[] get_varf() {
        int n = -b / (2 * a);
        int m = (a * n * n) + (b * n) + c;
        return new int[]{n, m};
    }

    public int[] get_mijloc(Parabola p) {
        int[] vf1 = this.get_varf();
        int[] vf2 = p.get_varf();

        int[] mijloc = new int[2];
        mijloc[0] = (vf1[0] + vf2[0]) / 2;
        mijloc[1] = (vf1[1] + vf2[1]) / 2;
        return mijloc;
    }

    // Metoda
    public double distanta_math(Parabola p) {
        int[] vf1 = this.get_varf();
        int[] vf2 = p.get_varf();
        return Math.hypot(vf1[0] - vf2[0], vf1[1] - vf2[1]);
    }

    @Override
    public String toString() {
        return "Parabola{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
