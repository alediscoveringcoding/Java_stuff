package ex1;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] judete = citesteJudete("src/ex1/judete_in.txt");

        if (judete != null) {
            Arrays.sort(judete); //sortam judetele în ordine alfabetica

            //afisam judetele ordonate
            System.out.println("judetele în ordine alfabetica");
            for (String j : judete) {
                System.out.println(j);
            }

            //cautam județul
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduceți judetul pe care il cauti ");
            String judetCautat = scanner.nextLine();

            int pozitie = Arrays.binarySearch(judete, judetCautat);
            if (pozitie >= 0) {
                System.out.println("judetul '" + judetCautat + "' se află pe poz " + (pozitie + 1));
            } else {
                System.out.println("judetul '" + judetCautat + "' nu a fost găsit");
            }
        }

    }

    public static String[] citesteJudete(String numeFisier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString().split("\n");
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fișier: " + e.getMessage());
            return null;
        }
    }
}

