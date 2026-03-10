package main.service;

import main.dto.enums.Cities;
import main.dto.request.UserRequest;
import main.entity.AppealsEntity;
import main.entity.AppealsStatusEntity;
import main.entity.CitiesEntity;
import main.repository.AppealsRepository;
import main.repository.AppealsStatusRepository;
import main.repository.CitiesRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class AppealsService {

    private final AppealsRepository appealsRepository;
    private final AppealsStatusRepository appealsStatusRepository;
    private final CitiesRepository citiesRepository;

    public AppealsService(AppealsRepository appealsRepository, AppealsStatusRepository appealsStatusRepository, CitiesRepository citiesRepository) {
        this.appealsRepository = appealsRepository;
        this.appealsStatusRepository = appealsStatusRepository;
        this.citiesRepository = citiesRepository;
    }

    @Transactional
    public void saveAppeal(UserRequest request){
        AppealsStatusEntity status = buildAppealStatus();

        CitiesEntity city = buildCity(request);

        AppealsEntity appeals = buildAppeal(request, status, city);

        appealsRepository.save(appeals);
    }

    private AppealsEntity buildAppeal(UserRequest request, AppealsStatusEntity status, CitiesEntity city){
        return AppealsEntity.builder()
                .appeal(request.getAppeal())
                .userIdentifier(getUserIdentifier())
                .appealsStatus(status)
                .resolvedAt(null)
                .city(city)
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
