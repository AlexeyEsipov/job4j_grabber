package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {
    private final int size;
    private final String regNumber;
    private boolean parking;
    private Ticket ticket;

    public Truck(int size, String regNumber, boolean parking) {
        if (size <= 1) {
            throw new IllegalArgumentException("Size is too small!");
        } else {
            this.size = size;
        }
        this.regNumber = regNumber;
        this.parking = parking;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getRegisterNumber() {
        return regNumber;
    }

    @Override
    public boolean isParking() {
        return parking;
    }

    @Override
    public void setParking(boolean parking) {
        this.parking = parking;
    }

    @Override
    public void acceptTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public Ticket returnTicket() {
        return ticket;
    }
}
