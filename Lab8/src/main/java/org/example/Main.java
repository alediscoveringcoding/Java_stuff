package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void afisare_tabela(Statement statement, String mesaj) {
        String sql = "SELECT * FROM persoane";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta=" + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afisarePersoanaExcursii(Connection connection) {
        String sql = """
                SELECT p.id AS id_persoana, p.nume AS nume, p.varsta, 
                       e.id_excursie, e.destinatia, e.anul
                FROM persoane p
                LEFT JOIN excursii e ON p.id = e.id_persoana
                ORDER BY p.id
                """;

        System.out.println("\n--- Lista persoanelor și excursiilor ---");
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            int lastPersonId = -1;
            while (rs.next()) {
                int personId = rs.getInt("id_persoana");
                String personName = rs.getString("nume");
                int personAge = rs.getInt("varsta");
                String destination = rs.getString("destinatia");
                int year = rs.getInt("anul");

                // If it's a new person, display their information
                if (personId != lastPersonId) {
                    if (lastPersonId != -1) {
                        System.out.println(); // New line between persons
                    }
                    System.out.println("Persoană: id=" + personId + ", nume=" + personName + ", vârstă=" + personAge);
                    System.out.println("Excursii:");
                    lastPersonId = personId;
                }

                if (destination != null) {
                    System.out.println(" - Destinație: " + destination + ", An: " + year);
                } else {
                    System.out.println(" - Nicio excursie");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void persoaneExcursiiAnIntrodus(Connection connection, int anul) {
        String sql = """
                SELECT p.id AS id_persoana, p.nume AS nume,
                       e.id_excursie, e.destinatia, e.anul
                FROM persoane p
                INNER JOIN excursii e ON p.id = e.id_persoana
                WHERE e.anul = ?
                """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, anul);
            try (ResultSet rs = stmt.executeQuery()) {
                boolean rezultat = false;
                while (rs.next()) {
                    if (!rezultat) {
                        System.out.println("Persoanele care au făcut excursii în anul " + anul + ":");
                        rezultat = true;
                    }
                    int id = rs.getInt("id_persoana");
                    String nume = rs.getString("nume");
                    System.out.println(" - ID: " + id + ", Nume: " + nume);
                }
                if (!rezultat) {
                    System.out.println("Nicio persoană nu a făcut excursii în anul " + anul);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lab8";
        String user = "root";
        String password = "Student123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            // Display the table
            afisare_tabela(statement, "Tabela Persoane:");

            // Display persons and excursions
            afisarePersoanaExcursii(connection);

            Scanner scanner = new Scanner(System.in);

            // Prompt for a year and display persons who traveled in that year
            System.out.println("Introduceți anul: ");
            int anul = scanner.nextInt();
            persoaneExcursiiAnIntrodus(connection, anul);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}