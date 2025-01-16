package ex2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Cantec {
    public static void main(String[] args) {
        String grupareFinala = "ing"; //gruparea de litere de verificat
        List<Vers> versuri = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get("src/ex2/cantec_in.txt"))) {
            versuri = stream.map(Vers::new).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/ex2/cantec_out.txt"))) {
            Random random = new Random();

            for (Vers vers : versuri) {
                boolean eCuMajuscule = random.nextDouble() < 0.1;
                String versText = eCuMajuscule ? vers.toString().toUpperCase() : vers.toString();
                long nrCuvinte = vers.getNumarCuvinte();
                long nrVocale = vers.getNumarVocale();
                String linieFinala = versText + " Cuvinte " + nrCuvinte + ", Vocale " + nrVocale;

                if (vers.seIncheieCu(grupareFinala)) {
                    linieFinala += " *";
                }

                writer.write(linieFinala);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
