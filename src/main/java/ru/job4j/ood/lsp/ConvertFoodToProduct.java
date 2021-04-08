package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class ConvertFoodToProduct {
    private final Food food;
    private final LocalDate currentDate;
    private final int rateInitDiscount;
    private final RemainingShelfLife remainingShelfLife;

    public ConvertFoodToProduct(Food food, LocalDate currentDate,
                                int rateInitDiscount, RemainingShelfLife remainingShelfLife) {
        this.food = food;
        this.currentDate = currentDate;
        this.rateInitDiscount = rateInitDiscount;
        this.remainingShelfLife = remainingShelfLife;
    }

    public Product getProduct() {
        int percent = remainingShelfLife.getPercentRemaining(food, currentDate);
        if (percent <= rateInitDiscount && percent > 0) {
            return new TakeDiscount(food, percent);
        } else {
            return new SimpleFood(food, percent);
        }
    }
}
