package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RemainingShelfLife {

    public int getPercentRemaining(Food food, LocalDate currentDate) {
        int period = (int) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int remaining = (int) ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        return 100 * remaining / period;
    }
}
