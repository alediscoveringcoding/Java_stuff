package ex1;

public class Main {
    public static void main(String[] args) {
        try {

            Parabola parabola1 = new Parabola(1, 2, 3);
            Parabola parabola2 = new Parabola(2, 3, 4);

            int[] varf1 = parabola1.get_varf();
            int[] varf2 = parabola2.get_varf();
            System.out.println("Mijlocul la parabola 1: (" + varf1[0] + ", " + varf1[1] + ")");
            System.out.println("Mijlocul la parabola 2: (" + varf2[0] + ", " + varf2[1] + ")");

            // Calculate and print the midpoint
            int[] mijloc = parabola1.get_mijloc(parabola2);
            System.out.println("Mijlocul este: (" + mijloc[0] + ", " + mijloc[1] + ")");

            double distanta1 = parabola1.distanta_math(parabola2);
            System.out.println("Distanta dintre cele 2 parabole este: " + distanta1);

            System.out.println(parabola1);
            System.out.println(parabola2);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
