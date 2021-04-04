package ru.job4j.ood.lsp;

import java.util.List;

public interface Store<T> {

    boolean add(T food);

    List<T> getStore();
}
