package ex4;

import java.time.LocalDate;
import java.util.Scanner;

class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        String anNastereString = cnp.substring(1, 3);
        int anNastere = Integer.parseInt(anNastereString);
        int anCurent = LocalDate.now().getYear() % 100;
        if (anNastere <= anCurent) {
            return anCurent - anNastere;
        } else {
            return 100 - (anNastere - anCurent);
        }
    }

    public char getSex() {
        return cnp.charAt(0);
    }

    public int getAnNastere() {
        String anNastereString = cnp.substring(1, 3);
        int anNastere = Integer.parseInt(anNastereString);
        int anCurent = LocalDate.now().getYear() % 100;
        if (anNastere <= anCurent) {
            return 2000 + anNastere;
        } else {
            return 1900 + anNastere;
        }
    }

    public int getLunaNastere() {
        return Integer.parseInt(cnp.substring(3, 5));
    }

    public int getZiuaNastere() {
        return Integer.parseInt(cnp.substring(5, 7));
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("introduceti nr de persoane");
            int n = scanner.nextInt();
            scanner.nextLine();

            Persoana[] persoane = new Persoana[n];

            for (int i = 0; i < n; i++) {
                System.out.println("introduceti numele persoanei " + (i + 1));
                String nume = scanner.nextLine();

                String cnp;
                boolean cnpValid = false;
                do {
                    System.out.println("introduceti CNP persoanei " + (i + 1) + ":");
                    cnp = scanner.nextLine();
                    cnpValid = isValidCNP(cnp);
                    if (!cnpValid) {
                        System.out.println("CNP introdus este invalid");
                    }
                } while (!cnpValid);

                persoane[i] = new Persoana(nume, cnp);
            }
            for (Persoana persoana : persoane) {
                System.out.println("nume " + persoana.getNume());
                System.out.println("CNP " + persoana.getCnp());
                System.out.println("sex " + (persoana.getSex() == '1' || persoana.getSex() == '5' ? "masculin" : "feminin"));
                System.out.println("varsta " + persoana.getVarsta());
                System.out.println("anul nasterii: " + persoana.getAnNastere());
                System.out.println("luna nasterii: " + persoana.getLunaNastere());
                System.out.println("ziua nasterii: " + persoana.getZiuaNastere());
                System.out.println();
            }
        }

        public static boolean isValidCNP(String cnp) {
            if (cnp.length() != 13) {
                return false;
            }
            for (char c : cnp.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            char primaCifra = cnp.charAt(0);
            if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
                return false;
            }
            return true;
        }
    }
}

