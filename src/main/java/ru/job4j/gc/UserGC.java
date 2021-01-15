package ru.job4j.gc;

public class UserGC {
    int a = 0;
    int[] ar1 = new int[245];

    public UserGC(int a) {
        this.a = a;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %n", this.a);
    }
}
