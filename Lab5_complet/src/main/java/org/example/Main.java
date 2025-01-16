package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void scriere(List<PerecheNumere> lista) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("perechi.json"), lista);
            System.out.println("Lista a fost salvată în perechi.json");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

    // Citește lista de perechi dintr-un fișier JSON
    public static List<PerecheNumere> citire() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("perechi.json"), new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fișier: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(3, 5));
        lista.add(new PerecheNumere(8, 13));
        lista.add(new PerecheNumere(21, 34));

        scriere(lista);

        List<PerecheNumere> perechiCitite = citire();
        perechiCitite.forEach(System.out::println);
    }
}
