package org.example.test1.Lab6.src.main.java.org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File file=new File("src/main/java/org/example/test1/Lab6/src/main/resources/angajati.json");
            mapper.writeValue(file,lista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/java/org/example/test1/Lab6/src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void afisaretoti(List<Angajat> angajati) {
        angajati.forEach(System.out::println);
    }
    public static void angajatipeste2500(List<Angajat>angajati)
    {
        Predicate<Angajat> peste = angajat -> angajat.getSalariu() > 2500; //am folosit predicate ca in cerinta
        List<Angajat> angajatipeste2500 = angajati.stream()
                .filter(peste)
                .collect(Collectors.toList());
        System.out.println("Angajatii cu salariul peste 2500 RON:");
        angajatipeste2500.forEach(System.out::println);

        /* mai usor
         angajati.stream()
                .filter(angajat -> angajat.getSalariu() > 2500)
                .forEach(System.out::println);*/
    }

    public static void numemajuscule(List<Angajat>angajati) {
        List<String> maj = angajati.stream()
                .map(angajat-> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        maj.forEach(System.out::println);
    }

    public static void salariusub3000(List<Angajat> angajati) {
        angajati.stream()
                .map(Angajat::getSalariu)
                .filter(salariu -> salariu < 3000)
                .forEach(System.out::println);
    }

    public static void verificareangajat(List<Angajat> angajati) {
        angajati.stream()
                .filter(angajat -> angajat.getNume().contains("Ana"))
                .findAny()
                .ifPresentOrElse(
                        angajat -> System.out.println("Firma are Ana"),
                        () -> System.out.println("Firma nu Ana"));
    }

    public static void main(String[] args) {
        List<Angajat> angajat=citire();

        //ciriea ex 1
        System.out.println("Lista angatatilor :");
        afisaretoti(angajat);

        //scriere
        angajat.add(new Angajat("Marin Ioana", "post nou", LocalDate.of(2022, 6, 15), 1000));
        scriere(angajat);
        System.out.println("a fost adaugat!!!!!!");

        //ex 2
        System.out.println("cu salariu peste 2500");
        angajatipeste2500(angajat);

        //ex 5
        System.out.println("numele de la angajat ce e cu majuscule");
        numemajuscule(angajat);

        //ex 6
        System.out.println("salariu sub 3000e");
        salariusub3000(angajat);

        //ex 9
        System.out.println("Verificare daca exista Ana");
        verificareangajat(angajat);
    }
}