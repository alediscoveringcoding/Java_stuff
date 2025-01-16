package org.example;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b=b;
    }

    public PerecheNumere(){ }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    public boolean auSumaCifrelorEgala() {
        return sumaCifrelor(a) == sumaCifrelor(b);
    }

    private int cmmdc(int a, int b) {
        while (b != 0) {
            int schimb = b;
            b = a % b;
            a = schimb;
        }
        return a;
    }

    private boolean patratperfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
