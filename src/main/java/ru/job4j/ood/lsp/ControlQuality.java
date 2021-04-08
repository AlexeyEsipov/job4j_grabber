package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {
    private final List<Store<Food>> listStore;
    private final int rateInitDiscount;
    private final RemainingShelfLife remainingShelfLife;

    public ControlQuality(List<Store<Food>> listStore,
                          int rateInitDiscount, RemainingShelfLife rsl) {
        this.listStore = listStore;
        this.rateInitDiscount = rateInitDiscount;
        this.remainingShelfLife = rsl;
    }

    public void distribute(List<Food> listFood, LocalDate currentDate) {
        Product product;
        for (Food food: listFood) {
            product = convertFoodToProduct(food, currentDate);
            for (Store<Food> store : listStore) {
                if (store.accept(product)) {
                    store.add(product);
                }
            }
        }
    }

    private Product convertFoodToProduct(Food food, LocalDate currentDate) {
        int percent = remainingShelfLife.getPercentRemaining(food, currentDate);
        if (percent <= rateInitDiscount && percent > 0) {
            return new TakeDiscount(food, percent);
        } else {
            return new SimpleFood(food, percent);
        }
    }
}
