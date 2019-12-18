package pl.uek.krakow.pp5.e2e;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uek.krakow.pp5.models.dto.CardBalanceDto;
import pl.uek.krakow.pp5.services.CreditCardFacade;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EndpointsTest {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate http;

	@Autowired
	CreditCardFacade creditCardFacade;

	@Test
	public void itListsCardBalances() {
		String uri = "/api/cards/balances";
		String url = String.format("http://localhost:%s%s", port, uri);

		ResponseEntity response = http.getForEntity(url, CardBalanceDto[].class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
