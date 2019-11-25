package pl.uek.krakow.pp5.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.uek.krakow.pp5.models.CreditCardFacade;
import pl.uek.krakow.pp5.models.commands.WithdrawCommand;
import pl.uek.krakow.pp5.models.dto.CardBalanceDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CreditCardReportingController {

	@Autowired
	CreditCardFacade api;

	@GetMapping("/balances")
	public List<CardBalanceDto> cardsBalances() {
		return Arrays.asList(
				new CardBalanceDto("1234", BigDecimal.valueOf(1000)),
				new CardBalanceDto("1234-1234", BigDecimal.valueOf(2000)),
				new CardBalanceDto("1234-1234", BigDecimal.valueOf(3000))
		);
	}

	@PostMapping("/withdraw")
	public WithdrawCommand withdraw(@RequestBody WithdrawCommand command) {
		return command;
	}
}
