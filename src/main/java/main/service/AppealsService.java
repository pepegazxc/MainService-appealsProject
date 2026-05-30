package main.service;

import lombok.RequiredArgsConstructor;
import main.dto.enums.Cities;
import main.dto.feign.InternalUserDto;
import main.dto.request.UserRequest;
import main.entity.AppealsEntity;
import main.entity.AppealsStatusEntity;
import main.entity.CitiesEntity;
import main.feign.RegistrationServiceClient;
import main.producer.KafkaProducer;
import main.repository.AppealsRepository;
import main.repository.AppealsStatusRepository;
import main.repository.CitiesRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AppealsService {

    private final AppealsRepository appealsRepository;
    private final AppealsStatusRepository appealsStatusRepository;
    private final CitiesRepository citiesRepository;
    private final RegistrationServiceClient userClient;
    private final KafkaProducer kafkaProducer;

    @Transactional
    public void saveAppeal(UserRequest request) {
        AppealsStatusEntity status = buildAppealStatus();
        CitiesEntity city = buildCity(request);
        AppealsEntity appeals = buildAppeal(request, status, city);

        appealsRepository.save(appeals);

        kafkaProducer.publicateNewMessageForMayor(
                appeals.getEmail(),
                appeals.getId(),
                appeals.getUserIdentifier(),
                appeals.getAppeal()
        );
    }

    private AppealsEntity buildAppeal(UserRequest request, AppealsStatusEntity status, CitiesEntity city){
        String userId = getUserIdentifier();
        InternalUserDto user = userClient.getEmail(userId);
        return AppealsEntity.builder()
                .appeal(request.getAppeal())
                .userIdentifier(userId)
                .appealsStatus(status)
                .resolvedAt(null)
                .city(city)
                .email(user.email())
                .build();
    }

    private AppealsStatusEntity buildAppealStatus(){
        return appealsStatusRepository.findByStatusName("NEW")
                .orElseThrow(() -> new IllegalStateException());
    }

    private CitiesEntity buildCity(UserRequest request){
        return citiesRepository.findById(checkCityName(request))
                .orElseThrow(() -> new IllegalStateException());
    }

    private Long checkCityName(UserRequest request){
        String input = request.getCityName().toString().toUpperCase().trim();
        Cities matches = Arrays.stream(Cities.values())
                .filter(cities -> cities.name().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());

        return matches.getId();
    }

    private String getUserIdentifier(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
