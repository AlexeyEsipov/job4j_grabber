package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarParkingTest {

    private final Vehicle car1 = new Car("car1", false);
    private final Vehicle car2 = new Car("car2", false);
    private final Vehicle car3 = new Car("car3", false);
    private final Vehicle truck1 = new Truck(2, "truck1", false);
    private final Vehicle truck2 = new Truck(2, "truck2", false);
    private final Vehicle truck3 = new Truck(3, "truck3", false);
    private final Vehicle truck5 = new Truck(2, "truck5", false);

    @Test     //когда нет грузовго паркинга, а на легковом недостаточно мест для грузовика
    public void isCarSpaceWhenNotTruckSpaceAndNotCarSpace() {
        CarParking carParking = new CarParking(2, 0);
        assertFalse(carParking.isCarSpace(truck3));
    }

    @Test   // когда есть место на грузовом паркинге
    public void isCarSpaceWhenTruckSpaceOK() {
        CarParking carParking = new CarParking(2, 1);
        assertTrue(carParking.isCarSpace(truck2));
    }

    @Test   //когда есть место на легковом паркинге для легкового авто
    public void isCarSpaceWhenCarSpaceOK() {
        CarParking carParking = new CarParking(2, 1);
        assertTrue(carParking.isCarSpace(car2));
    }

    @Test   // когда грузовой паркинг занят, а на легковом недостаточно места для грузовика
    public void isCarSpaceWhen1TruckOKBut2TruckNotOK() {
        CarParking carParking = new CarParking(1, 1);
        Ticket ticket = new Card("Truck", new int[]{1, 0}, "truck1");
        carParking.takeThePlaceOf(ticket);
        assertFalse(carParking.isCarSpace(truck3));
    }

    @Test   // когда грузовой паркинг занят, а на легковом достаточно места для грузовика
    public void isCarSpaceWhen1TruckOKBut2TruckOnlyCarPlaces() {
        CarParking carParking = new CarParking(3, 1);
        Ticket ticket = new Card("Truck", new int[]{1, 0}, "truck1");
        carParking.takeThePlaceOf(ticket);
        assertTrue(carParking.isCarSpace(truck3));
    }

    @Test   // выделить место под грузовик
    public void getCarSpaceWhen1TruckOK() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket = carParking.getCarSpace(truck1);
        String expectedDivision = "Truck";
        String expectedNumber = "truck1";
        int[] expectedPlaces = new int[]{1, 0};
        assertEquals(expectedDivision, ticket.getDivision());
        assertEquals(expectedNumber, ticket.getCarNumber());
        assertArrayEquals(expectedPlaces, ticket.getPlaces());
    }

    @Test   // выделить место под грузовик на легковом паркинге, когда грузовой паркинг занят
    public void getCarSpaceWhen2TruckOK() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket1 = carParking.getCarSpace(truck3);
        carParking.takeThePlaceOf(ticket1);
        Ticket ticket5 = carParking.getCarSpace(truck5);
        String expectedDivision = "Car";
        String expectedNumber = "truck5";
        int[] expectedPlaces = new int[]{1, 2};
        assertEquals(expectedDivision, ticket5.getDivision());
        assertEquals(expectedNumber, ticket5.getCarNumber());
        assertArrayEquals(expectedPlaces, ticket5.getPlaces());
    }

    @Test   // пометить место свободным когда автомобиль покинул паркинг
    public void whenEmptySpace() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket1 = carParking.getCarSpace(truck1);
        // размещаем автомобиль
        carParking.takeThePlaceOf(ticket1);
        String[] expectedFreightStatus = new String[]{"truck1"};
        // автомобиль размещен и присутствует в списке
        assertArrayEquals(expectedFreightStatus, carParking.getFreightStatus());
        // автомобиль покинул паркинг
        carParking.emptySpace(ticket1);
        String[] expectedEmptyFreightStatus = new String[0];
        assertArrayEquals(expectedEmptyFreightStatus, carParking.getFreightStatus());
    }
}