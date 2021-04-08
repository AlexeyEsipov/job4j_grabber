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
            ConvertFoodToProduct convert =
                    new ConvertFoodToProduct(food, currentDate,
                            rateInitDiscount, remainingShelfLife);
            product = convert.getProduct();
            for (Store<Food> store : listStore) {
                if (store.accept(product)) {
                    store.add(product);
                }
            }
        }
    }
}
