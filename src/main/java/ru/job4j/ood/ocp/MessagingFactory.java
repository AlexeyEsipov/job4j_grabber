package ru.job4j.ood.ocp;

public class MessagingFactory {
    public IMessagingService initializeMessage(String deliveryType) {
        IMessagingService result = null;
        if (deliveryType.equals("email")) {
            result = new EmailService();
        } else if (deliveryType.equals("sms")) {
            result = new SmsService();
        }
        return result;
    }
}
