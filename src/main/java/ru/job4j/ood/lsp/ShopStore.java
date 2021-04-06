package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShopStore<T extends Food> implements Store<Food> {
    private final int rateStore;
    private final List<Food> listStore = new ArrayList<>();

    public ShopStore(int rateStore) {
        this.rateStore = rateStore;
    }

    @Override
    public List<Food> getStore() {
        return listStore;
    }

    @Override
    public boolean accept(Food food, LocalDate currentDate) {
        boolean result = false;
        int percent = food.getPercentRemaining(currentDate);
        if (percent <= rateStore && percent > 0) {
            result = listStore.add(food);
        }
        return result;
    }
}
