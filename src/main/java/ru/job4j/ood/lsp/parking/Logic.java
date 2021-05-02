package ru.job4j.ood.lsp.parking;

import java.util.Arrays;

public class Logic implements PlacementLogic {

    public boolean ability(int size, int[] carParkingArea, int[] truckParkingArea) {
        Ticket card = getContinuousPlaces(size, carParkingArea, truckParkingArea);
        return !card.getDivision().equals("No places");
    }

    public Ticket getContinuousPlaces(int size, int[] carParkingArea, int[] truckParkingArea) {
        String division = "No places";
        int[] multiPlaces = new int[size];
        String carNumber = "";
        if (size == 1) {
            int singlePlace = findSinglePlace(carParkingArea);
            if (singlePlace > 0) {
                division = "Car";
                multiPlaces[0] = singlePlace;
            }
        }
        if (size > 1) {
            int singlePlace = findSinglePlace(truckParkingArea);
            if (singlePlace > 0) {
                division = "Truck";
                multiPlaces[0] = singlePlace;
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
        for (int i = 0; i <= parkingArea.length - size; i++) {
            if (parkingArea[i] > 0) {
                continue;
            }
            int k = 0;
            for (int j = 0; j < size; j++) {
                k = k + parkingArea[i + j];
                if (k == 0) {
                    places[j] = i + j + 1;
                }
            }
            if (k == 0) {
                break;
            } else {
                Arrays.fill(places, 0);
            }
        }
        return places;
    }
}
