package org.noctisdev.payments.application.factory;

import lombok.Builder;
import org.noctisdev.payments.domain.broker.IMessageProducer;
import org.noctisdev.payments.domain.events.EventType;
import org.noctisdev.payments.domain.events.NotificationEvent;

@Builder
public class EventFactory {

    private EventType type;
    private String email;
    private String phoneNumber;
    private String message;
    private String subject;
    private IMessageProducer producer;

    public interface Notification {
        void send();
    }

    public Notification getNotification() {
        NotificationEvent event = new NotificationEvent();

        event.setType(type);
        event.setDestination(email);
        event.setSubject(subject);
        event.setMessage(message);

        return () -> producer.sendNotification(event);
    }

}
