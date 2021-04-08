package ru.job4j.ood.lsp;

public class TakeDiscount implements Product {
    private final Food food;
    private final int percentRemaining;

    public TakeDiscount(Food food, int percentRemaining) {
        this.food = food;
        this.percentRemaining = percentRemaining;
    }

    @Override
    public Food getFood() {
        food.setPrice(food.getPrice() - food.getDiscount());
        return food;
    }

    @Override
    public int getPercentRemaining() {
        return percentRemaining;
    }
}
