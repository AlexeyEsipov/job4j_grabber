package ru.job4j.ood.ocp;

public class MessagingService {
    public static void send(MessagingFactory messFactory, String deliveryType, String content) {
        IMessagingService messagingService = messFactory.initializeMessage(deliveryType);
        messagingService.send(content);
    }
}
