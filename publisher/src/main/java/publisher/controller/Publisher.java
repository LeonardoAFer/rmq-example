package publisher.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import publisher.service.PublisherService;

@RestController
@Slf4j
public class Publisher {

    @Value("${rabbitmq.queuename}")
    private String queue;

    private final PublisherService publisherService;

    Publisher(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("publish/text")
    public void publish(@RequestBody String text) {
        log.info("[m=publish]Calling publish: {}", text);
        publisherService.publishMessage(text, queue);
    }

}
