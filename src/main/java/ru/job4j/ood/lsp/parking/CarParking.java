package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements ParkingArea {

    private final int[] carArray;
    private final int[] truckArray;
    private final PlacementLogic logic;

    private final List<String> carList = new ArrayList<>();
    private final List<String> truckList = new ArrayList<>();

    public CarParking(int carArray, int truckArray, PlacementLogic logic) {
        this.carArray = new int[carArray];
        this.truckArray = new int[truckArray];
        this.logic = logic;
    }

    // этот метод сообщает, есть ли свободное место
    @Override
    public boolean isCarSpace(Vehicle vehicle) {

        validateVehicle(vehicle);

        int size = vehicle.getSize();

        return logic.ability(size, carArray, truckArray);
    }

    // этот метод формирует парковочный талон с указанием парковочных мест
    @Override
    public Ticket getCarSpace(Vehicle vehicle) {

        validateVehicle(vehicle);

        String division = "";
        String carNumber = vehicle.getRegisterNumber();
        int size = vehicle.getSize();
        int[] places = new int[size];

        if (logic.ability(size, carArray, truckArray)) {
            Ticket card = logic.getContinuousPlaces(size, carArray, truckArray);
            division = card.getDivision();
            places = card.getPlaces();
        }
        return new Card(division, places, carNumber);
    }

    // при убытии автомобиля на основании возвращенного парковочного талона
    // помечаются свободные места
    @Override
    public boolean emptySpace(Ticket ticket) {

        validateTicket(ticket);

        boolean result = false;
        String division = ticket.getDivision();
        String carNumber = ticket.getCarNumber();
        int[] places = ticket.getPlaces();

        if (division.equals("Car")) {
            for (int i = 0; i < places.length; i++) {
                if (carArray[places[i] - 1] == 0) {
                    return false;
                }
                carArray[places[i] - 1] = 0;
                carList.remove(carNumber);
                result = true;
            }
        } else {
            if (truckArray[places[0] - 1] == 0) {
                return false;
            }
            truckArray[places[0] - 1] = 0;
            truckList.remove(carNumber);
            result = true;
        }
        return result;
    }

    // при прибытии автомобиля на основании парковочного талона
    // помечаются занятые места
    @Override
    public boolean takeThePlaceOf(Ticket ticket) {

        validateTicket(ticket);

        boolean result = false;
        String division = ticket.getDivision();
        String carNumber = ticket.getCarNumber();
        int[] places = ticket.getPlaces();

        if (division.equals("Car")) {
            for (int j = 0; j < places.length; j++) {
                if (j == 0) {
                    carList.add(carNumber);
                }
                carArray[places[j] - 1] = 1;
            }
            result = true;
        } else {
            truckArray[places[0] - 1] = 1;
            truckList.add(carNumber);
            result = true;
        }
        return result;
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
