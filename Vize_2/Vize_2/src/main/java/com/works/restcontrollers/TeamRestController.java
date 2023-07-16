package com.works.restcontrollers;

import com.works.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamRestController {

    final TeamService teamService;
    final HttpServletRequest req;

    @PostMapping("/teamInsert/{teamName}")
    public ResponseEntity teamInsert(@PathVariable String teamName) {
        boolean loginStatus = req.getSession().getAttribute("user") == null;
        if (loginStatus) {
            return new ResponseEntity("Please Login", HttpStatus.UNAUTHORIZED);
        }
        return teamService.save(teamName);
    }

}
