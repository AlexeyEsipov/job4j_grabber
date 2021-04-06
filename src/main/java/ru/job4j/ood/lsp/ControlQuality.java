package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality<T extends Store<Food>> {
    private final List<Store<Food>> listStore;
    private final int rateInitDiscount;

    public ControlQuality(List<Store<Food>> listStore, int rateInitDiscount) {
        this.listStore = listStore;
        this.rateInitDiscount = rateInitDiscount;
    }

    public void distribute(List<Food> listFood, LocalDate currentDate) {
        for (Food food: listFood) {
            int percent = food.getPercentRemaining(currentDate);
            if (percent > 0 && percent < rateInitDiscount) {
                food.setPrice(food.getPrice() - food.getDiscount());
            }
            for (Store<Food> store : listStore) {
                if (store.accept(food, currentDate)) {
                    break;
                }
            }
        }
    }
}
