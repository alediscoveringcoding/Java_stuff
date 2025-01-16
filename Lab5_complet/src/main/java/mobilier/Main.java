package mobilier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/mobilier.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Mobilier> mob = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>(){});
            return mob;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();//pt lista mea
    }

    // afisare cu tot cu placa si tot
    public static void afisareMobilier(List<Mobilier> mobilierList)
    {
        for (Mobilier mobilier : mobilierList) {
            System.out.println("Piesa de mobilier " + mobilier.getNume());
            System.out.println("Placi");
            for (Placa placa : mobilier.getPlaci()) {
                System.out.println("Descriere " + placa.getDescriere());
                System.out.println("Lungime " + placa.getLungime() + " mm");
                System.out.println("Latime " + placa.getLatime() + " mm");
                System.out.println("Nr_bucati " + placa.getNr_bucati() + " mm");
            }
            System.out.println();
        }
    }

    //afisare caracteristici speciale gen dupa nume
    public static void afisaredupanume(List<Mobilier> mobilierList, String numeMobilier) {
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(numeMobilier)) {
                System.out.println("Caracteristici " + mobilier.getNume());
                for (Placa placa : mobilier.getPlaci()) {
                    System.out.println("Descriere " + placa.getDescriere());
                    System.out.println("Lungime " + placa.getLungime() + " mm");
                    System.out.println("Lățime " + placa.getLatime() + " mm");
                    System.out.println("Orientare " + placa.getOrientare());
                    System.out.println("Nr_bucăți " + placa.getNr_bucati());
                }
                return;
            }
        }
        System.out.println("Mobilierul cu numele \"" + numeMobilier + "\" nu a fost găsit.");
    }

    //functie ce calculeaza chestii din problema
    public static void calcul(List<Mobilier> mobilierList, String numeMobilier) {
        System.out.println("Mobilierul cu numele \"" + numeMobilier);
    }


    public static void main(String[] args) {
        List<Mobilier> mob=citire();
        System.out.println("Mobilierul"+ mob);

        //mu o sa putem asa pt ca avem array
        /*for(Mobilier p:mob){
            System.out.println(p);
        }
        mob.add(new Placa("Descriere", 33, 4, Orientare.LUNGIME, new boolean[]{false, true, true, false}, 55));*/

        List<Placa> placiNoi = new ArrayList<>();
        placiNoi.add(new Placa("Spatar", 1000, 600, Orientare.LUNGIME, new boolean[]{true, true, true, true}, 5));
        placiNoi.add(new Placa("Fatada", 800, 50, Orientare.LUNGIME, new boolean[]{false, true, true, false}, 3));
        mob.add(new Mobilier("Dulap", placiNoi));
        scriere(mob);

        System.out.println("Caracteristicile doar pt mobilierul ce e denumit Dulap");
        afisaredupanume(mob, "Dulap");

        System.out.println("Calcule");
        calcul(mob,"Dulap");
    }

}
