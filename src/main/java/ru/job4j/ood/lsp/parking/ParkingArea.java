package ru.job4j.ood.lsp.parking;

public interface ParkingArea {

    // Есть ли свободное место для авто?
    // Сведения об автомобиле передаются
    // через переменную vehicle
    boolean isCarSpace(Vehicle vehicle);

    // Сообщить номер парковочного места
    // (или последовательность мест)
    // в парковочном талоне Ticket
    Ticket getCarSpace(Vehicle vehicle);

    // Пометить место как свободное
    void emptySpace(Ticket ticket);

    // Пометить место как занятое
    void takeThePlaceOf(Ticket ticket);

    // Сообщить регистрационные номера находящихся на парковке легковых автомобилей
    String[] getCarStatus();

    // Сообщить регистрационные номера находящихся на парковке грузовых автомобилей
    String[] getFreightStatus();
}

