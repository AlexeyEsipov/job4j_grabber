package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store<Food>> listStore;
    private final int rateInitDiscount;
    private final RemainingShelfLife remainingShelfLife;
    private final ConvertFoodToProduct convert;

    public ControlQuality(List<Store<Food>> listStore,
                          int rateInitDiscount, RemainingShelfLife rsl,
                          ConvertFoodToProduct convert) {
        this.listStore = listStore;
        this.rateInitDiscount = rateInitDiscount;
        this.remainingShelfLife = rsl;
        this.convert = convert;
    }

    public void distribute(List<Food> listFood, LocalDate currentDate) {
        Product product;
        for (Food food: listFood) {
            product = convert.getProduct(food, currentDate, rateInitDiscount, remainingShelfLife);
            for (Store<Food> store : listStore) {
                if (store.accept(product)) {
                    store.add(product);
                }
            }
        }
    }

    public void resort(LocalDate resortDate) {
        List<Food> listFood = new ArrayList<>();
        for (Store<Food> store : listStore) {
            listFood.addAll(store.getStore());
            store.clearStore();
        }
        distribute(listFood, resortDate);
    }
}
