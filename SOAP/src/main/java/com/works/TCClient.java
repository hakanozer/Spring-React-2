package com.works;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrulaResponse;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrula;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TCClient extends WebServiceGatewaySupport {

    public TCClient(WebServiceTemplate webServiceTemplate) {
        super.setWebServiceTemplate(webServiceTemplate);
    }

    public TCKimlikNoDogrulaResponse tcKimlikNoDogrula(TCKimlikNoDogrula tcKimlikNoDogrula){
        TCKimlikNoDogrulaResponse res = (TCKimlikNoDogrulaResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx",
                        tcKimlikNoDogrula,
                        new SoapActionCallback(
                                "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula"
                        )
                );
        return res;
    }

}
