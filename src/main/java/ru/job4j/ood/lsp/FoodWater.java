package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class FoodWater extends Food {
    public FoodWater(String name, LocalDate createDate, LocalDate expiryDate,
                     double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}