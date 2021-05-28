package ru.job4j.ood.ocp;

public class SmsService implements IMessagingService {
    @Override
    public void send(String content) {
        System.out.println("send sms: " + content);
    }
}
