package com.works.restcontrollers;

import com.works.services.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class DummyRestController {

    final DummyService dummyService;

    @GetMapping("/allProduct")
    public Object allProduct() {
        return dummyService.getAllProduct();
    }

}
