package pl.uek.krakow.pp5.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.uek.krakow.pp5.services.CreditCardFacade;

@Configuration
public class CreditCardConfiguration {

	@Bean
	CreditCardFacade thereIsCCApi() {
		return new CreditCardFacade();
	}
}
