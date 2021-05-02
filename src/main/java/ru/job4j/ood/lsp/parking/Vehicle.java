package ru.job4j.ood.lsp.parking;

public interface Vehicle {

    // размер автомобиля
    int getSize();

    // регистрационный номер
    String getRegisterNumber();

    // статус автомобиля:
    // - автомобиль на парковке - true
    // - автомобиль не на парковке - false
    boolean isParking();

    // изменить статус автомобиля - припаркован: true; - неприпаркован: false
    void setParking(boolean parking);

    // получить талон с указанием парковочных мест
    void acceptTicket(Ticket ticket);

    // вернуть талон при покидании парковки
    Ticket returnTicket();
}
