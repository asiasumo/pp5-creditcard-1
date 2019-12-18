package pl.uek.krakow.pp5.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import pl.uek.krakow.pp5.models.CreditCard;
import pl.uek.krakow.pp5.models.commands.WithdrawCommand;
import pl.uek.krakow.pp5.models.dto.CardBalanceDto;

import java.beans.BeanProperty;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class CreditCardFacade {

	private CreditCardStorage storage;

	public void withdraw(WithdrawCommand command) {
		CreditCard card = this.storage.load(command.getCardNumber());

		card.withdraw(command.getWithdrawAmount());

		storage.add(card);
	}

	public List<CardBalanceDto> getAll() {
		return storage.all().stream()
				.map(creditCard -> new CardBalanceDto(creditCard.getCardNumber(), creditCard.getBalance()))
				.collect(Collectors.toList());
	}
}
