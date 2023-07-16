package com.works.services;

import com.works.entites.Footballer;
import com.works.entites.Team;
import com.works.projections.IFootballer;
import com.works.repositories.FootballerRepository;
import com.works.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballerService {

    final FootballerRepository footballerRepository;
    final TeamRepository teamRepository;
    final HttpServletRequest req;

    public ResponseEntity register(Footballer footballer) {
        try {
            Optional<Footballer> optionalFootballer = footballerRepository.findByEmailEqualsIgnoreCase(footballer.getEmail());
            if ( optionalFootballer.isPresent()) {
                return new ResponseEntity( footballer.getEmail() + ": This Email Using!", HttpStatus.BAD_REQUEST);
            }else {
                footballerRepository.save(footballer);
                return new ResponseEntity(footballer, HttpStatus.OK);
            }
        }catch (Exception ex) {
           return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity login(Footballer footballer) {
        Optional<Footballer> optionalFootballer = footballerRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(footballer.getEmail(), footballer.getPassword());
        if (optionalFootballer.isPresent()) {
            req.getSession().setAttribute("user", optionalFootballer.get());
            return new ResponseEntity(optionalFootballer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity("Email or Password Fail", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity teamCreate() {
        List<IFootballer> alist = footballerRepository.getTeamCreate("A", 6, 0);
        List<IFootballer> blist = footballerRepository.getTeamCreate("B", 6, 0);
        Map hm = new LinkedHashMap();
        hm.put("A",alist );
        hm.put("B",blist );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity backUpCreate() {
        List<IFootballer> alist = footballerRepository.getTeamCreate("A", 3, 7);
        List<IFootballer> blist = footballerRepository.getTeamCreate("B", 3, 7);
        Map hm = new LinkedHashMap();
        hm.put("A",alist );
        hm.put("B",blist );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity allCreate() {
        List<Team> allTeams = teamRepository.findAll();
        Map hm = new LinkedHashMap();
        for ( Team item : allTeams ) {
            List<IFootballer> list = footballerRepository.getTeamCreate(item.getName(), 6, 0);
            hm.put(item.getName(), list );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
