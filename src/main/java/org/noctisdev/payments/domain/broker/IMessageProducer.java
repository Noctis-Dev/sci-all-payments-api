package org.noctisdev.payments.domain.broker;

import org.noctisdev.payments.domain.events.NotificationEvent;

public interface IMessageProducer {

    void sendNotification(NotificationEvent event);

}
