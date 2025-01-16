package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("lungimea este: ");
        int lungime=new Scanner(System.in).nextInt();
        System.out.println("latimea este: ");
        int latime=new Scanner(System.in).nextInt();
        int perimetru;
        int arie;
        perimetru=2*(lungime+latime);
        arie=lungime*latime;

        System.out.println("perimetrul este: ");
        System.out.println(perimetru);
        System.out.println("aria este: ");
        System.out.println(arie);
    }
}