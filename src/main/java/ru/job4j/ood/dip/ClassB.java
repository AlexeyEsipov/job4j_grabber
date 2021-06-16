package ru.job4j.ood.dip;

public class ClassB implements Iabc {
    private String s;

    public ClassB(String s) {
        this.s = s;
    }

    @Override
    public String getS() {
        return s;
    }
}
