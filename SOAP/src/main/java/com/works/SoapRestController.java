package com.works;

import com.example.consumingwebservice.wsdl.TCKimlikNoDogrula;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrulaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

@RestController
public class SoapRestController {

    final WebServiceTemplate webServiceTemplate;
    public SoapRestController(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }


    @GetMapping("/soap")
    public void soap() {
        TCClient tcClient = new TCClient(webServiceTemplate);
        TCKimlikNoDogrula obj = new TCKimlikNoDogrula();
        obj.setAd("Ertan");
        obj.setSoyad("Kaya");
        obj.setDogumYili(1997);
        obj.setTCKimlikNo(26167660802L);

        TCKimlikNoDogrulaResponse tcResponse = tcClient.tcKimlikNoDogrula(obj);
        boolean verificationResult = tcResponse.isTCKimlikNoDogrulaResult();
        System.out.println("Response: " + verificationResult);
    }


}
