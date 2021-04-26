package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarParkingTest {

    private final Vehicle car1 = new Car(2, "truck1", false);
    private final Vehicle car2 = new Car(1, "car2", false);
    private final Vehicle car3 = new Car(3, "truck3", false);
    private final Vehicle car5 = new Car(2, "truck5", false);

    @Test
    public void isCarSpaceWhenNotTruckSpaceAndNotCarSpace() {
        CarParking carParking = new CarParking(2, 0);
        assertFalse(carParking.isCarSpace(car3));
    }

    @Test
    public void isCarSpaceWhenTruckSpaceOK() {
        CarParking carParking = new CarParking(2, 1);
        assertTrue(carParking.isCarSpace(car3));
    }

    @Test
    public void isCarSpaceWhenCarSpaceOK() {
        CarParking carParking = new CarParking(2, 1);
        assertTrue(carParking.isCarSpace(car2));
    }

    @Test
    public void isCarSpaceWhen1TruckOKBut2TruckNotOK() {
        CarParking carParking = new CarParking(1, 1);
        Ticket ticket = new Card("Truck", new int[]{1, 0}, "truck1");
        carParking.takeThePlaceOf(ticket);
        assertFalse(carParking.isCarSpace(car3));
    }

    @Test
    public void isCarSpaceWhen1TruckOKBut2TruckOnlyCarPlaces() {
        CarParking carParking = new CarParking(3, 1);
        Ticket ticket = new Card("Truck", new int[]{1, 0}, "truck1");
        carParking.takeThePlaceOf(ticket);
        assertTrue(carParking.isCarSpace(car3));
    }

    @Test
    public void getCarSpaceWhen1TruckOK() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket = carParking.getCarSpace(car1);
        String expectedDivision = "Truck";
        String expectedNumber = "truck1";
        int[] expectedPlaces = new int[]{1, 0};
        assertEquals(expectedDivision, ticket.getDivision());
        assertEquals(expectedNumber, ticket.getCarNumber());
        assertArrayEquals(expectedPlaces, ticket.getPlaces());
    }

    @Test
    public void getCarSpaceWhen2TruckOK() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket1 = carParking.getCarSpace(car1);
        carParking.takeThePlaceOf(ticket1);
        Ticket ticket5 = carParking.getCarSpace(car5);
        String expectedDivision = "Car";
        String expectedNumber = "truck5";
        int[] expectedPlaces = new int[]{1, 2};
        assertEquals(expectedDivision, ticket5.getDivision());
        assertEquals(expectedNumber, ticket5.getCarNumber());
        assertArrayEquals(expectedPlaces, ticket5.getPlaces());
    }

    @Test
    public void whenEmptySpace() {
        CarParking carParking = new CarParking(2, 1);
        Ticket ticket1 = carParking.getCarSpace(car1);
        carParking.takeThePlaceOf(ticket1);
        String[] expectedFreightStatus = new String[]{"truck1"};
        assertArrayEquals(expectedFreightStatus, carParking.getFreightStatus());
        carParking.emptySpace(ticket1);
        String[] expectedEmptyFreightStatus = new String[0];
        assertArrayEquals(expectedEmptyFreightStatus, carParking.getFreightStatus());
    }
}