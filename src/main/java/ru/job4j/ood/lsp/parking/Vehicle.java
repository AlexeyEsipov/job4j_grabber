package ru.job4j.ood.lsp.parking;

public interface Vehicle {

    // размер автомобиля
    int getSize();

    // регистрационный номер
    String getRegisterNumber();

    // статус автомобиля:
    // - автомобиль на парковке - true
    // - автомобиль не на парковке - false
    boolean onParking();
}
