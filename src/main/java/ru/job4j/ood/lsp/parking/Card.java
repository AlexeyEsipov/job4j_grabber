package ru.job4j.ood.lsp.parking;

import java.util.Arrays;

public class Card implements Ticket {
    private final String division;
    private final int[] places;
    private final String carNumber;

    public Card(String division, int[] places, String carNumber) {
        this.division = division;
        this.places = places;
        this.carNumber = carNumber;
    }

    @Override
    public String getDivision() {
        return division;
    }

    @Override
    public int[] getPlaces() {
        return places;
    }

    @Override
    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "Card{" + "division='" + division + '\''
                + ", places=" + Arrays.toString(places)
                + ", carNumber='" + carNumber + '\''
                + '}';
    }
}
