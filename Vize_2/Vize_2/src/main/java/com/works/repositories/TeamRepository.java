package com.works.repositories;

import com.works.entites.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByNameEqualsAndFidEqualsAllIgnoreCase(String name, Long fid);

}