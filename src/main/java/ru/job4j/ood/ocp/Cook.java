package ru.job4j.ood.ocp;

public class Cook {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    public void makeDinner(IMeal meal) {
        meal.make();
    }
}
