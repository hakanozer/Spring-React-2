package com.works.restcontrollers;

import com.works.entites.Footballer;
import com.works.services.FootballerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/footballer")
public class FootballerRestController {

    final FootballerService footballerService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Footballer footballer) {
        return footballerService.register(footballer);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Footballer footballer) {
        return footballerService.login(footballer);
    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate() {
        return footballerService.teamCreate();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate() {
        return footballerService.backUpCreate();
    }

    @GetMapping("/allCreate")
    public ResponseEntity allCreate() {
        return footballerService.allCreate();
    }

}
