package ex_carte;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void scriere(Map<Integer, Carte> carti) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/carti.json");
            // deserializare in Map<Integer, Carte>
            return objectMapper.readValue(file, new TypeReference<Map<Integer, Carte>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(); // gol daca nu e oke
        }
    }

    public static void afisare(Map<Integer, Carte> carti) {
        carti.forEach((id, carte) -> {
            System.out.println("ID: " + id + ", " + carte);
        });
    }

    public static void sterge(Map<Integer, Carte> carti, int id) {
        if (carti.containsKey(id)) {
            carti.remove(id);
            System.out.println("cartea" + id + " a fost stearsa");
        }
    }

    public static void adauga(Map<Integer, Carte> carti, int id, Carte carte) {
        if (!carti.containsKey(id)) {
            carti.put(id, carte);
            System.out.println("cartea" + carte.getTitlu() + "a fost adaugaa");
        }
    }

    public static void afisarespeciala(Map<Integer, Carte> carti) {
        // extragem din Map si le afisam
        carti.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.getAutor()))
                .forEach(carte -> System.out.println(carte));
    }


    public static void afisarespecialaordonata(Map<Integer, Carte> carti) {
        carti.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.getAutor()))
                .sorted(Comparator.comparing(Carte::getTitlu))
                .forEach(carte -> System.out.println(carte));
    }

    public static void main(String[] args) {
        Map<Integer, Carte> carti = citire();
        afisare(carti);
        sterge(carti, 1);  // Șterge cartea cu ID-ul 1
        adauga(carti, 7, new Carte("Noua carte", "AAA", 2003));
        scriere(carti);
        //Set<Carte> harariCarti = creazaSetHarari(carti);
        afisarespeciala(carti);
        afisarespeciala(carti);
        //afiseazaCeaMaiVecheCarte(harariCarti);

    }
}