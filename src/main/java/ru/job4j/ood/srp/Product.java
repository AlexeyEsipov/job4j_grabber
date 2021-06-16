package ru.job4j.ood.srp;

public class Product {
    private String name = " ";
    private int value = 0;

    public Product(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    void rename(String newName) {
        if (newName != null) {
            this.name = newName;
        }
    }

    void resize(int newValue) {
        this.value = newValue;
    }

    public void print() {
        System.out.println("Product " + this.name + ": value " + this.value);
    }

}
