package ru.job4j.ood.lsp.parking;

public interface PlacementLogic {

    boolean ability(int size, int[] carParkingArea, int[] truckParkingArea);

    Ticket getContinuousPlaces(int size, int[] carParkingArea, int[] truckParkingArea);
}
