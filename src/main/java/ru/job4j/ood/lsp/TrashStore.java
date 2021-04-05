package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrashStore<T extends Food> implements Store<Food> {
    private final List<Food> listStore = new ArrayList<>();

    @Override
    public List<Food> getStore() {
        return listStore;
    }

    @Override
    public boolean accept(Food food, LocalDate currentDate, int rateWarehouse, int rateShop) {
        boolean result = false;
        int percent = food.getPercentRemaining(currentDate);
        if (percent <= 0) {
            result = listStore.add(food);
        }
        return result;
    }
}
