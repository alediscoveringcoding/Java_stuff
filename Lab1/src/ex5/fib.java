package ex5;

import java.util.Random;

public class fib {
    public static void main(String[] args)
    {
        Random random = new Random();
        int num1 = random.nextInt(20) + 1;

        System.out.println("numarul 1: " + num1);
        int n=num1;
        if(n == 1) { //Caz particular
            System.out.println("DA");
        } else
        {
            //generam șirul Fibonacci pentru a verifica dacă n face parte din sir
            //c = fn, b = fn-1, a = fn-2
            int a = 1, b = 1, c;
            int esteTermenFib = 0; //in caz că nu este termen Fibonacci, afisam NU la final
            do {
                c = a + b;
                a = b;
                b = c;
                if(n == c) { //Este termen Fibonacci
                    esteTermenFib = 1;
                    System.out.println("DA");
                    break;
                }
            } while(c <= n);
            if(esteTermenFib == 0) { //Nu este termen Fibonacci
                System.out.println("NU");
            }
        }
    }
}
