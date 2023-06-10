package com.works.restcontrollers;

import com.works.models.MusicCategoryList;
import com.works.services.MozartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mozart")
public class MozartRestController {

    final MozartService mozartService;

    @GetMapping("/service")
    public MusicCategoryList service() {
        return mozartService.result();
    }

    @GetMapping("/news")
    public void news() {
        mozartService.news();
    }

}
