package ru.job4j.ood.ocp;

public class Probe {
    public static void Send(String deliveryType, String content) {
        if (deliveryType.equals("email")) {
            System.out.println("send email: " + content);
        } else {
            System.out.println("send sms: " + content);
        }
    }
}
