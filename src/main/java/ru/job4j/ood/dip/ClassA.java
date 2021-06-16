package ru.job4j.ood.dip;

public class ClassA {
    private Iabc b;

    public ClassA(Iabc b) {
        this.b = b;
    }

    public void print(Iabc b, Output output) {
        output.println(b.getS());
    }
}
