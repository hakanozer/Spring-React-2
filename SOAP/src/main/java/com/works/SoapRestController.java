package com.works;

import com.example.consumingwebservice.wsdl.TCKimlikNoDogrula;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrulaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapRestController {

    final TCClient tcClient;
    public SoapRestController(TCClient tcClient) {
        this.tcClient = tcClient;
    }

    @GetMapping("/soap")
    public void soap() {
        TCKimlikNoDogrula obj = new TCKimlikNoDogrula();
        obj.setAd("Hakan");
        obj.setSoyad("Özer");
        obj.setDogumYili(1981);
        obj.setTCKimlikNo(12345678912L);
        TCKimlikNoDogrulaResponse res = tcClient.tcKimlikNoDogrula(obj);
        System.out.println( res.isTCKimlikNoDogrulaResult() );
    }


}
