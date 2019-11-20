package pl.uek.krakow.pp5.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfiguration {

	@Bean
	CreditCardFacade thereIsCCApi() {
		return new CreditCardFacade();
	}
}
