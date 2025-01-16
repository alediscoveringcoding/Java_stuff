package ex3;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        System.out.print("Numarul dat este= ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nrDiviz = 0;

        System.out.print("Divizorii sunt: \n");
        for(int i = 1; i<=n; i++)
        {
            if(n%i == 0){
                nrDiviz++;
                System.out.println(i);
            }
        }

        if(nrDiviz == 2){
            System.out.println("Numarul "+ n +" este prim");
        }else{
            System.out.println("Numarul "+ n +" nu este prim");
        }
    }
}