package main.producer;

import lombok.RequiredArgsConstructor;
import main.event.EventClass;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, EventClass> kafka;

    public void publicateNewMessageForMayor(){
        //TO DO: IMPLEMENT THE METHOD REALIZATION AND CREATE KAFKA TOPIC
    }
}
