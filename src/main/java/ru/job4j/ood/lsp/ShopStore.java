package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ShopStore<T extends Food> implements Store<T> {

    private final List<T> listStore = new ArrayList<>();

    @Override
    public boolean add(T food) {
        return listStore.add(food);
    }

    @Override
    public List<T> getStore() {
        return listStore;
    }
}
