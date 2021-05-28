package ru.job4j.ood.ocp;

public class EmailService implements IMessagingService {
    @Override
    public void send(String content) {
        System.out.println("send email: " + content);
    }
}
