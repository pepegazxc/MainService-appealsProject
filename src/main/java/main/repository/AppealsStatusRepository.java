package main.repository;

import main.entity.AppealsStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppealsStatusRepository extends JpaRepository<AppealsStatusEntity, Long> {
    Optional<AppealsStatusEntity> findIdByStatusName(String status);
}
