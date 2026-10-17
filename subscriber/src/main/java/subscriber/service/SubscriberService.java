package subscriber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriberService {

    @RabbitListener(queues = "${rabbitmq.queuename}")
    public void receiveMessage(Message message){
        log.info("[m=receiveMessage] Message received {}", message);
    }

}
