package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

@SpringBootApplication
@EnableScheduling
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	
	 
/*	  CommandLineRunner lookup(CountryClient quoteClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	        country = args[0];
	      }
	      GetCountryResponse response = quoteClient.getCountry(country);
	      System.err.println(response.getCountry().getCurrency());
		System.err.println(response);
	    };
	  }*/
}
