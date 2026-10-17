package publisher.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PublisherService {

    private final RabbitTemplate rabbitTemplate;

    PublisherService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessage(String message, String queueName){
       log.info("[m=publishMessage] Publishing message {} queue {}", message, queueName);
       this.rabbitTemplate.convertAndSend(queueName, message);
    }

}
