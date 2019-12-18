package pl.uek.krakow.pp5.rest;

import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.uek.krakow.pp5.models.commands.WithdrawCommand;
import pl.uek.krakow.pp5.models.dto.CardBalanceDto;
import pl.uek.krakow.pp5.services.CreditCardFacade;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CreditCardReportingController {

	@Autowired
	CreditCardFacade api;

	@GetMapping("/balances")
	public List<CardBalanceDto> cardsBalances() {
		return api.getAll();
	}

	@PostMapping("/withdraw")
	public Response withdraw(@RequestBody WithdrawCommand command) {
		return null;
	}
}
