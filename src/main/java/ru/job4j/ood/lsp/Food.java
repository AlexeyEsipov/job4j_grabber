package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Food {
    private final String name;
    private final LocalDate createDate;
    private final LocalDate expiryDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate createDate, LocalDate expiryDate,
                double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getPercentRemaining(LocalDate currentDate) {
        int period = (int) ChronoUnit.DAYS.between(getCreateDate(), getExpiryDate());
        int remaining = (int) ChronoUnit.DAYS.between(currentDate, getExpiryDate());
        return 100 * remaining / period;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + price
                + '}';
    }
}
