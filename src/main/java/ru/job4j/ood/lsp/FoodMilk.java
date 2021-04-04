package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class FoodMilk extends Food {
    public FoodMilk(String name, LocalDate createDate, LocalDate expiryDate,
                    double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
