package com.works.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Currency {

    private String currencyName;
    private String forexBuying;
    private String forexSelling;
    private String banknoteBuying;
    private String banknoteSelling;

}
