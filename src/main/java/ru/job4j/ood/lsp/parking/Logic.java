package ru.job4j.ood.lsp.parking;

import java.util.Arrays;

public class Logic implements PlacementLogic {

    public boolean ability(int size, int[] carParkingArea,
                           int countFreeCarPark, int countFreeTruckPark) {
        if (size == 1) {
            return countFreeCarPark > 0;
        }
        if (size > 1 && countFreeTruckPark > 0) {
            return true;
        }
        Ticket card = getContinuousPlaces(size, carParkingArea,
                                            countFreeCarPark, countFreeTruckPark);
        return !card.getDivision().equals("No places");
    }

    public Ticket getContinuousPlaces(int size, int[] carParkingArea,
                                      int countFreeCarPark, int countFreeTruckPark) {
        String division = "No places";
        int[] multiPlaces = new int[size];
        String carNumber = "";
        if (size == 1 && countFreeCarPark > 0) {
            division = "Car";
            multiPlaces[0] = findSinglePlace(carParkingArea);
        }
        if (size > 1) {
            if (countFreeTruckPark > 0) {
                division = "Truck";
                multiPlaces[0] = 1;
            } else {
              multiPlaces = findContinuousPlaces(size, carParkingArea);
              if (multiPlaces[0] > 0) {
                  division = "Car";
              }
            }
        }
        return new Card(division, multiPlaces, carNumber);
    }

    private int findSinglePlace(int[] parkingArea) {
        int result = 0;
        for (int i : parkingArea) {
            if (i == 0) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    private int[] findContinuousPlaces(int size, int[] parkingArea) {
        int[] places = new int[size];
        int i = 0;
        int j = 0;
        int needPlaces = size;
        while (i < parkingArea.length) {
            if (j == size) {
                break;
            }
            if (parkingArea[i] == 0) {
                places[j] = i + 1;
                needPlaces--;
            } else {
                j = -1;
                needPlaces = size;
                Arrays.fill(places, 0);
            }
            j++;
            i++;
            if (i == parkingArea.length && needPlaces != 0) {
                Arrays.fill(places, 0);
            }
        }
        return places;
    }
}
