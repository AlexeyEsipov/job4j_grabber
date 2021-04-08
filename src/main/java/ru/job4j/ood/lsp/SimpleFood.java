package ru.job4j.ood.lsp;

public class SimpleFood implements Product {
    private final Food food;
    private final int percentRemaining;

    public SimpleFood(Food food, int percentRemaining) {
        this.food = food;
        this.percentRemaining = percentRemaining;
    }

    @Override
    public Food getFood() {
        return food;
    }

    @Override
    public int getPercentRemaining() {
        return percentRemaining;
    }
}
