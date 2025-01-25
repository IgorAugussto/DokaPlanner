package com.doka.organizer.repository;

import com.doka.organizer.entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinistryRepository extends JpaRepository<Ministry, Long> {
    Optional<Ministry> findByName(String name);
}
