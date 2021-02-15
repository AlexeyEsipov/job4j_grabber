package ru.job4j.gc.ref;

public class UserCash {
    public static void main(String[] args) {
        Cash cash = new Cash();
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println("Убираем мусор ");
        System.gc();
        System.out.println("После уборки ");
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
        System.out.println(cash.getFile("./data/proba.txt"));
    }
}
