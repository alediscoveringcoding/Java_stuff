import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void adaugare(List<Echipament> echipament) throws IOException {
        File f = new File("src/fisier.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line; //liniile citite din fisier
        while ((line = br.readLine()) != null) {
            String[] split = line.split(";");
            String denumire = split[0].trim();
            int nr_inventar = Integer.parseInt(split[1].trim());
            int pret = Integer.parseInt(split[2].trim());
            Echipament.ZonaMag zonamag = Echipament.ZonaMag.valueOf(split[3].trim());
            Echipament.Stare stare = Echipament.Stare.valueOf(((split[4].trim().toUpperCase())));
            String tip = split[5].trim();
            switch (tip) {
                case "imprimanta":
                    int ppm = Integer.parseInt(split[6].trim());
                    String rezolutie = split[7].trim();
                    int p_car = Integer.parseInt(split[8].trim());
                    Imprimante.ModTiparire tiparire = Imprimante.ModTiparire.valueOf(split[9].trim().toUpperCase());
                    echipament.add(new Imprimante(denumire, nr_inventar, pret, zonamag, stare, ppm, rezolutie, p_car, tiparire));
                    break;

                case "copiator":
                    int p_ton = Integer.parseInt(split[6].trim());
                    Copiatoare.Format format = Copiatoare.Format.valueOf(split[7].trim());
                    echipament.add(new Copiatoare(denumire, nr_inventar, pret, zonamag, stare, p_ton, format));
                    break;

                case "sistem de calcul":
                    String tip_mon = split[6].trim();
                    double vit_proc = Double.parseDouble(split[7].trim());
                    int c_hdd = Integer.parseInt(split[8].trim());
                    Sisteme_calcul.Sistemm sistem = Sisteme_calcul.Sistemm.valueOf(split[9].trim().toUpperCase());
                    echipament.add(new Sisteme_calcul(denumire, nr_inventar, pret, zonamag, stare, tip_mon, vit_proc, c_hdd, sistem));
                    break;
            }
        }

    }
    public static void afisare(List<Echipament> echipament) {
        for(Echipament e : echipament) {
            System.out.println(e);
            //System.out.println();
        }

    }
    public static void afisare_imprimante(List<Echipament> echipament)
    {
        for(Echipament e : echipament){
            if(e instanceof Imprimante)
                System.out.println(e.toString());
            System.out.println();
        }
    }

    public static void afisare_copiatoare(List<Echipament> echipamente)
    {
        for(Echipament e:echipamente)
        {
            if(e instanceof Copiatoare)
            {
                System.out.println(e.toString());
                System.out.println();
            }
        }
    }
    public static void afisare_sisteme(List<Echipament> echipament)
    {
        for(Echipament e:echipament)
        {
            if(e instanceof Sisteme_calcul) {
                System.out.println(e.toString());
                System.out.println();
            }
        }
    }


    public static void modificare_stare(List<Echipament> echipamente, Echipament.Stare nouaStare,int nr_inventar){
        for(Echipament e: echipamente)
        {

        }
    }

    public static void afisare_vandut(List<Echipament> echipament){
        for(Echipament e:echipament){
            if(e.getStare()== Echipament.Stare.VANDUT)
            {
                System.out.println(e.toString());
                System.out.println();
            }
        }
    }

    public static void format_copiere(List<Echipament> echipament) {
        //Setarea unui format de copiere pentru copiatoare
        for (Echipament e : echipament) {
            e.setFormat(Copiatoare.Format.A3);
            System.out.println(e.toString());
            System.out.println();

        }
    }
    public static void instaleazaSistemOperare(List<Echipament> echipament, Sisteme_calcul.Sistemm sistemNou) {

        for (Echipament sistem : echipament) {
            sistem.setSistem(sistemNou); //setam noul sistem de operare
            System.out.println("Sistemul de operare " + sistemNou + "a fost instalat "+sistem.toString());
        }
    }


    public static void main(String[] args) throws IOException {
        List<Echipament> echipament = new ArrayList<Echipament>();
        //de pus adaugarea dupa List
        adaugare(echipament);
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("1Afişarea tuturor echipamentelor");
            System.out.println("2Afişarea imprimantelor");
            System.out.println("3Afişarea copiatoarelor");
            System.out.println("4Afişarea sistemelor de calcul");
            System.out.println("5Modificarea stării în care se află un echipament ");
            System.out.println("6Afişarea echipamentelor vândute");
            System.out.println("7Setarea unui format de copiere pentru copiatoare ");
            System.out.println("8Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("opt este: ");
            opt = scanner.nextInt();
            switch (opt) {
                case 0:
                    exit(0);
                    break;
                case 1:
                    afisare(echipament);
                    //System.out.println(echipament);
                    break;
                case 2:
                    afisare_imprimante(echipament);
                    break;
                case 3:
                    afisare_copiatoare(echipament);
                    break;
                case 4:
                    afisare_sisteme(echipament);
                    break;
                case 5:
                    break;
                case 6:
                    afisare_vandut(echipament);
                    break;
                case 7:
                    format_copiere(echipament);
                    break;
                case 8:
                    instaleazaSistemOperare(echipament, Sisteme_calcul.Sistemm.LINUX);
                    break;

                default:
                    System.out.println("Opt nu exista");
                    break;
            }
        } while (true);
    }
}