package main.repository;

import main.entity.CitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitiesRepository extends JpaRepository<CitiesEntity, Long> {
    Optional<CitiesEntity> findById(Long Id);

}
