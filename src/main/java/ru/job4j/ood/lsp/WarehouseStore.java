package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class WarehouseStore implements Store<Food> {
    private final int rateStore;
    private final List<Food> listStore = new ArrayList<>();

    public WarehouseStore(int rateStore) {
        this.rateStore = rateStore;
    }

    @Override
    public List<Food> getStore() {
        return listStore;
    }

    @Override
    public boolean accept(Product product) {
        boolean result = false;
        int percent = product.getPercentRemaining();
        if (percent > rateStore) {
            result = true;
        }
        return result;
    }

    @Override
    public void add(Product product) {
        listStore.add(product.getFood());
    }
}
