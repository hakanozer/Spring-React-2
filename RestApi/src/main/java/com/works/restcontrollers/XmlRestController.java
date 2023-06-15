package com.works.restcontrollers;

import com.works.models.Currency;
import com.works.services.XmlRead;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/xml")
public class XmlRestController {

    final XmlRead xmlRead;

    @GetMapping("/read")
    public List<Currency> read() {
        List<Currency> ls = xmlRead.result();
        return ls;
    }


}
