package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class ConvertFoodToProduct {

    public Product getProduct(Food food, LocalDate currentDate,
                              int rateInitDiscount, RemainingShelfLife remainingShelfLife) {
        int percent = remainingShelfLife.getPercentRemaining(food, currentDate);
        if (percent <= rateInitDiscount && percent > 0) {
            return new TakeDiscount(food, percent);
        } else {
            return new SimpleFood(food, percent);
        }
    }
}
