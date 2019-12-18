package pl.uek.krakow.pp5.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SqlCreditCardStorageTest {

	public static final String CREDIT_CARD_NUMBER = "1234";
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Test
	public void itAllowToStoreCC() {
		SqlCreditCardStorage sqlCreditCardStorage = new SqlCreditCardStorage(jdbcTemplate);

		CreditCard card = getCreditCard();
		sqlCreditCardStorage.add(card);

		CreditCard loaded = sqlCreditCardStorage.load(card.getCardNumber());
		assertThat(CREDIT_CARD_NUMBER).isEqualTo(loaded.getCardNumber());
	}

	private CreditCard getCreditCard(){
		return CreditCard.builder()
				.cardNumber(CREDIT_CARD_NUMBER)
				.limit(BigDecimal.valueOf(1000))
				.build();
	}
}
