package ru.job4j.ood.lsp;

import java.util.List;

public interface Store<T extends Food> {

    List<T> getStore();

    boolean accept(Product product);

    void add(Product product);
}
