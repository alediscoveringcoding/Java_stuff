package ex4;

import java.util.Random;

public class ex4 {

    public static void main(String[] args)
    {
        Random random = new Random();
        int num1 = random.nextInt(30) + 1; //folosim random din nou
        int num2 = random.nextInt(30) + 1;

        System.out.println("numarul 1: " + num1);
        System.out.println("numarul 2: " + num2);

        int a=num1;
        int b=num2;
        while(b != 0) {
            int r = a % b; //restul impartirii lui a la b
            a = b;
            b = r;
        }
        System.out.println("CMMDC este: "+a);
    }
}

