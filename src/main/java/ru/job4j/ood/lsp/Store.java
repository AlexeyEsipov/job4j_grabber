package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Store<T extends Food> {

    List<T> getStore();

    boolean accept(T food, LocalDate currentDate, int rateWarehouse, int rateShop);
}
