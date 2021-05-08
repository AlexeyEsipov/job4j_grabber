package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements ParkingArea {

    private final int[] carArray;
    private int countFreeTruckPark;
    private int countFreeCarPark;

    private final PlacementLogic logic;

    private final List<String> carList = new ArrayList<>();
    private final List<String> truckList = new ArrayList<>();

    public CarParking(int carArray, int truckArray, PlacementLogic logic) {
        this.carArray = new int[carArray];
        this.logic = logic;
        this.countFreeTruckPark = truckArray;
        this.countFreeCarPark = carArray;
    }

    // этот метод сообщает, есть ли свободное место
    @Override
    public boolean isCarSpace(Vehicle vehicle) {

        validateVehicle(vehicle);

        int size = vehicle.getSize();
        return logic.ability(size, carArray, countFreeCarPark, countFreeTruckPark);
    }

    // этот метод формирует парковочный талон с указанием парковочных мест
    @Override
    public Ticket getCarSpace(Vehicle vehicle) {

        validateVehicle(vehicle);

        String division = "";
        String carNumber = vehicle.getRegisterNumber();
        int size = vehicle.getSize();
        int[] places = new int[size];

        if (logic.ability(size, carArray, countFreeCarPark, countFreeTruckPark)) {
            Ticket card = logic.getContinuousPlaces(size, carArray,
                    countFreeCarPark, countFreeTruckPark);
            division = card.getDivision();
            places = card.getPlaces();
        }
        return new Card(division, places, carNumber);
    }

    // при убытии автомобиля на основании возвращенного парковочного талона
    // помечаются свободные места
    @Override
    public void emptySpace(Ticket ticket) {

        validateTicket(ticket);

        String division = ticket.getDivision();
        String carNumber = ticket.getCarNumber();
        int[] places = ticket.getPlaces();

        if (division.equals("Car")) {
            for (int i = 0; i < places.length; i++) {
                carArray[places[i] - 1] = 0;
                countFreeCarPark++;
                carList.remove(carNumber);
            }
        } else {
            countFreeTruckPark++;
            truckList.remove(carNumber);
        }
    }

    // при прибытии автомобиля на основании парковочного талона
    // помечаются занятые места
    @Override
    public void takeThePlaceOf(Ticket ticket) {

        validateTicket(ticket);

        String division = ticket.getDivision();
        String carNumber = ticket.getCarNumber();
        int[] places = ticket.getPlaces();

        if (division.equals("Car")) {
            for (int j = 0; j < places.length; j++) {
                if (j == 0) {
                    carList.add(carNumber);
                }
                carArray[places[j] - 1] = 1;
                countFreeCarPark--;
            }
        } else {
            countFreeTruckPark--;
            truckList.add(carNumber);
        }
    }

    @Override
    public String[] getCarStatus() {
        return carList.toArray(new String[0]);
    }

    @Override
    public String[] getFreightStatus() {
        return truckList.toArray(new String[0]);
    }

    // автомобиль должен иметь регистрационный номер и размер
    private void validateVehicle(Vehicle vehicle) {
        if (vehicle.getSize() < 1 && vehicle.getRegisterNumber() == null) {
            throw new IllegalArgumentException("Incorrect Car Data");
        }
    }

    // проверка корректности данных парковочного талона
    private void validateTicket(Ticket ticket) {
        String division = ticket.getDivision();
        if (!(division.equals("Car") || division.equals("Truck"))) {
            throw new IllegalArgumentException("Incorrect Ticket Division");
        }
        int[] places = ticket.getPlaces();
        if (places.length < 1) {
            throw new IllegalArgumentException("Incorrect Ticket Places");
        }
    }

}
