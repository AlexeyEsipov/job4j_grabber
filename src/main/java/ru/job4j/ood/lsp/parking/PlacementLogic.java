package ru.job4j.ood.lsp.parking;

public interface PlacementLogic {

    boolean ability(int size, int[] carParkingArea,
                    int countFreeCarPark, int countFreeTruckPark);

    Ticket getContinuousPlaces(int size, int[] carParkingArea,
                               int countFreeCarPark, int countFreeTruckPark);
}
