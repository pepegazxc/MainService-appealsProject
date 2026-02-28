package main.repository;

import main.entity.AppealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealsRepository extends JpaRepository<AppealsEntity, Long> {
}
