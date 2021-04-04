package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality<T extends Food> {

    private final Store<T> warehouseStore;
    private final Store<T> shopStore;
    private final Store<T> trashStore;

    public ControlQuality(Store<T> warehouseStore, Store<T> shopStore, Store<T> trashStore) {
        this.warehouseStore = warehouseStore;
        this.shopStore = shopStore;
        this.trashStore = trashStore;
    }

    public void distribute(List<T> listFood, LocalDate currentDate,
                           int rateWarehouse, int rateShop) {
        for (T item: listFood) {
            int percent = item.getPercentRemaining(currentDate);
            if (percent <= 0) {
                trashStore.add(item);
            } else if (percent >= rateWarehouse) {
                warehouseStore.add(item);
            } else if (percent >= rateShop) {
                shopStore.add(item);
            } else {
                item.setPrice(item.getPrice() - item.getDiscount());
                shopStore.add(item);
            }
        }
    }
}
