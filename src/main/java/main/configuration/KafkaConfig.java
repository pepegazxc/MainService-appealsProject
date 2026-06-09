package main.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    @Bean
    public NewTopic messageToMayorTopic(){
        return TopicBuilder.name("mayor-message")
                .replicas(1)
                .partitions(3)
                .build();
    }
    @Bean
    public NewTopic appealResponseTopic(){
        return TopicBuilder.name("appeal-response")
                .replicas(1)
                .partitions(3)
                .build();
    }

}
