package com.example.consumingwebservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;

@Component
public class SchedulingClient extends WebServiceGatewaySupport{
	private static final Logger log = LoggerFactory.getLogger(SchedulingClient.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@PostConstruct
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
	
	@Scheduled(fixedRate=4000)
	public GetCountryResponse fetchData()
	{
		 GetCountryRequest request = new GetCountryRequest();
		    request.setName("Spain");

		    log.info("Requesting location for " + request.getName());

		    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
		        .marshalSendAndReceive("http://localhost:8080/ws/countries", request);
		    log.info("Currency is::"+response.getCountry().getCurrency()+"::Name is::"+response.getCountry().getName()+
		    		"::Population is::"+response.getCountry().getPopulation());
		    return response;
	}
}
