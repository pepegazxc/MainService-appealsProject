package main.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    public NewTopic messageToMayorTopic(){
        return TopicBuilder.name("mayor-message")
                .replicas(1)
                .partitions(3)
                .build();
    }
}
