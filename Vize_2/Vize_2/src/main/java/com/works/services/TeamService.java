package com.works.services;

import com.works.entites.Footballer;
import com.works.entites.Team;
import com.works.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    final TeamRepository teamRepository;
    final HttpServletRequest req;

    public ResponseEntity save(String teamName) {
        Footballer footballer = (Footballer) req.getSession().getAttribute("user");
        Optional<Team> optionalTeam = teamRepository.findByNameEqualsAndFidEqualsAllIgnoreCase(teamName, footballer.getFid());
        if (optionalTeam.isPresent()) {
            return new ResponseEntity("Save Fail!", HttpStatus.BAD_REQUEST);
        }else {
            Team team = new Team();
            team.setFid(footballer.getFid());
            team.setName(teamName);
            teamRepository.save(team);
            return new ResponseEntity(team, HttpStatus.OK);
        }
    }

}
