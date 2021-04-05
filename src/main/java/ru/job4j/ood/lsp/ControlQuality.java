package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality<T extends Store<Food>> {
    private final List<Store<Food>> listStore;

    public ControlQuality(List<Store<Food>> listStore) {
        this.listStore = listStore;
    }

    public void distribute(List<Food> listFood, LocalDate currentDate,
                           int rateWarehouse, int rateShop) {
        for (Food item: listFood) {
            for (Store<Food> store : listStore) {
                if (store.accept(item, currentDate, rateWarehouse, rateShop)) {
                    break;
                }
            }
        }
    }
}
