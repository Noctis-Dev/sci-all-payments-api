package org.noctisdev.payments.infraestructure.broker;

import org.noctisdev.payments.domain.broker.IMessageProducer;
import org.noctisdev.payments.domain.events.NotificationEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements IMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendNotification(NotificationEvent event) {
        rabbitTemplate.convertAndSend("Notification", event);
    }
}
