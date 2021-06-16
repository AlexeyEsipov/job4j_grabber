package ru.job4j.ood.dip;

public class Burner implements IHeat {

    @Override
    public void engage() {
        System.out.println("Engage");
    }

    @Override
    public void disengage() {
        System.out.println("Disengage");
    }
}
