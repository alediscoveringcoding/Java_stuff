package ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void meniu()
    {
        System.out.println("alege optiunea: ");
        System.out.println("1 pt afisarea tuturor produselor ");
        System.out.println("2 pt afisarea produselor expirate ");
        System.out.println("3 vanzarea produsului ");
        System.out.println("4 afisarea produselor cu pret minim ");
        System.out.println(" 0 exit: ");
    }
    public static void adaugaredinfiser(List<Produs>prod) throws IOException {
        File file=new File("src/ex2/produse.csv");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line;

        while((line=br.readLine())!=null)
        {
            //String denumire, double pret, int cantitate, LocalDate data
            String[] split=line.split(",");
            String denumire=split[0].trim();
            double pret = Double.parseDouble(split[1].trim());
            int cantitate = Integer.parseInt(split[2].trim());
            LocalDate data=LocalDate.parse(split[3].trim());
            prod.add(new Produs(denumire,pret,cantitate,data));
        }
    }

    public static void afisare(List<Produs>prod)
    {
        for(Produs p:prod)
        {
            System.out.println(p);
        }
    }
    public static void expirat(List<Produs> prod) {
        LocalDate today = LocalDate.now();
        for (Produs p : prod) {
            if (p.getData().isBefore(today)) {
                System.out.println(p + " expirat");
            } else {
                System.out.println(p + " nu e expirat");
            }
        }
    }
    public static void pretmin(List<Produs> prod) {
        Produs minPretProdus = prod.get(0);
        for (Produs p : prod) {
            if (p.getPret() < minPretProdus.getPret()) {
                minPretProdus = p;
            }
        }
        System.out.println("produsul cu pret minim " + minPretProdus);
    }

    public static void vanzare(List<Produs> prod, String denumireProdus, int cantitateVanduta) {
        for (Produs p : prod) {
            if (p.getDenumire().equalsIgnoreCase(denumireProdus)) {
                p.vindeProdus(cantitateVanduta);
                return;
            }
        }
        System.out.println("Produsul nu a fost găsit");
    }


    public static void main(String[] args) throws IOException {
        List<Produs> prod = new ArrayList<>();
        adaugaredinfiser(prod);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            meniu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    afisare(prod);
                    break;
                case 2:
                    expirat(prod);
                    break;
                case 3:
                    System.out.print("introduceti denumirea produsului");
                    String denumire = scanner.nextLine();
                    System.out.print("introduceti cantitatea de vândut");
                    int cantitate = scanner.nextInt();
                    vanzare(prod, denumire, cantitate);  // vanzarea unui produs
                    break;
                case 4:
                    pretmin(prod);
                    break;
                case 0:
                    running = false;
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("nu exista");
            }
        }
        scanner.close();
    }

}
