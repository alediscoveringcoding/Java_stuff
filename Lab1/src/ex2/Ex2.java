package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        File inputFile = new File("src/ex2/in.txt"); //declrare si initializare fisiere
        File outputFile = new File("src/ex2/out.txt");

        try {
            Scanner scanner = new Scanner(inputFile); //deschidere fisier
            FileWriter writer = new FileWriter(outputFile); //scriere

            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            int count = 0;

            while (scanner.hasNext()) {
                double num = scanner.nextDouble(); //citeste fiecare numar
                sum += num;
                count++;
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }

            double average = sum / count;

            System.out.println("Suma " + sum);
            System.out.println("Media aritmetica " + average);
            System.out.println("Valoarea minima " + min);
            System.out.println("Valoarea maxima " + max);

            writer.write("Suma " + sum + "\n");
            writer.write("Media aritmetica " + average + "\n");
            writer.write("Valoarea minima " + min + "\n");
            writer.write("Valoarea maxima " + max + "\n");

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("fisierul de intrare nu exista");
        } catch (IOException e) {
            System.err.println("eroare la scrierea în out.txt");
        }
    }
}

