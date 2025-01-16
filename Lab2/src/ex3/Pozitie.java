package ex3;

public class Pozitie {
    public static void main(String[] args) {
        StringBuilder sir=new StringBuilder("testareexercitiu");
        String sir2="cenecereincerinta";
        sir.insert(5,sir2);
        System.out.println(sir.toString()); //pt a afisa noul sir

        sir.delete(14,20);
        System.out.println(sir.toString());
    }
}