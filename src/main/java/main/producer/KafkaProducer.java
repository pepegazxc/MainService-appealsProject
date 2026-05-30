package main.producer;

import lombok.RequiredArgsConstructor;
import main.event.EventClass;
import main.event.MayorEvent;
import main.feign.RegistrationServiceClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, EventClass> kafka;
    private final RegistrationServiceClient registrationServiceClient;

    public void publicateNewMessageForMayor(String userEmail, Long appealId, String userIdentifier, String appeal){
        MayorEvent event = new MayorEvent();
        buildEvent(event, userEmail, appealId, userIdentifier, appeal);
        event.setMayorsEmails(registrationServiceClient.getMayorEmails().email());
        kafka.send(
                "mayor-message" ,event
        );
    }

    private MayorEvent buildEvent(MayorEvent event, String userEmail, Long appealId, String userIdentifier, String appeal){
        event.setUserEmail(userEmail);
        event.setAppealId(appealId);
        event.setUserIdentifier(userIdentifier);
        event.setAppeal(appeal);
        return event;
    }
}
