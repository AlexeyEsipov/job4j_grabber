package ru.job4j.ood.dip;

public class Thermometer implements IThermo {

    @Override
    public double read() {
        return Math.random() * 100;
    }
}
