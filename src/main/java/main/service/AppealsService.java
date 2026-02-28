package main.service;

import main.dto.request.UserRequest;
import main.entity.AppealsEntity;
import main.repository.AppealsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppealsService {

    private final AppealsRepository appealsRepository;

    public AppealsService(AppealsRepository appealsRepository) {
        this.appealsRepository = appealsRepository;
    }

    public void saveAppeal(UserRequest request){
        AppealsEntity appeals = buildAppeal(request);

        appealsRepository.save(appeals);
    }

    private AppealsEntity buildAppeal(UserRequest request){
        return AppealsEntity.builder()
                .appeal(request.getAppeal())
                .userIdentifier(getUserIdentifier())
                .build();
    }

    private String getUserIdentifier(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
