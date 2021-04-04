package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class FoodBeer extends Food {
    public FoodBeer(String name, LocalDate createDate, LocalDate expiryDate,
                    double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}

