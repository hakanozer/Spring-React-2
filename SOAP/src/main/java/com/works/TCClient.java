package com.works;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrula;
import com.example.consumingwebservice.wsdl.TCKimlikNoDogrulaResponse;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TCClient extends WebServiceGatewaySupport {


    public TCKimlikNoDogrulaResponse tcKimlikNoDogrula( TCKimlikNoDogrula tcKimlikNoDogrula  ) {
        TCKimlikNoDogrulaResponse res = (TCKimlikNoDogrulaResponse) getWebServiceTemplate().marshalSendAndReceive(tcKimlikNoDogrula);
        return res;
    }


}
