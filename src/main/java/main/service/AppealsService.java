package main.service;

import main.dto.request.UserRequest;
import main.entity.AppealsEntity;
import main.entity.AppealsStatusEntity;
import main.repository.AppealsRepository;
import main.repository.AppealsStatusRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class AppealsService {

    private final AppealsRepository appealsRepository;
    private final AppealsStatusRepository appealsStatusRepository;

    public AppealsService(AppealsRepository appealsRepository, AppealsStatusRepository appealsStatusRepository) {
        this.appealsRepository = appealsRepository;
        this.appealsStatusRepository = appealsStatusRepository;
    }

    @Transactional
    public void saveAppeal(UserRequest request){
        AppealsStatusEntity status = buildAppealStatus();


        AppealsEntity appeals = buildAppeal(request, status);

        appealsRepository.save(appeals);
    }

    private AppealsEntity buildAppeal(UserRequest request, AppealsStatusEntity status){
        return AppealsEntity.builder()
                .appeal(request.getAppeal())
                .userIdentifier(getUserIdentifier())
                .appealsStatus(status)
                .resolvedAt()
                .build();
    }

    private AppealsStatusEntity buildAppealStatus(){
        return appealsStatusRepository.findIdByStatusName("NEW")
                .orElseThrow(() -> new IllegalStateException());
    }

    private String getUserIdentifier(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
