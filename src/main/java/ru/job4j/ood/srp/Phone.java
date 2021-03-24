package ru.job4j.ood.srp;

public class Phone {
    public void dial(String phoneNumber) {
        System.out.println("connected established " + phoneNumber);
    }

    public void disconnect(String phoneNumber) {
        System.out.println("disconnected " + phoneNumber);
    }

    public void send(String message) {
        System.out.println("data sent successfully");
    }

    public int receive() {
        System.out.println("data received successfully");
        return  0;
    }
}
