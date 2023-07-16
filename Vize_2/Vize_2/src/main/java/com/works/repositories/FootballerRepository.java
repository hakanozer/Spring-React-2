package com.works.repositories;

import com.works.entites.Footballer;
import com.works.projections.IFootballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
    Optional<Footballer> findByEmailEqualsIgnoreCase(String email);

    Optional<Footballer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

    @Query(value = "select F.NAME, F.SURNAME, F.AGE from TEAM inner join FOOTBALLER F on TEAM.FID = F.FID where TEAM.NAME = ?1 order by F.AGE asc limit ?2 offset ?3", nativeQuery = true)
    List<IFootballer> getTeamCreate( String teamName, int limit, int offset);


}