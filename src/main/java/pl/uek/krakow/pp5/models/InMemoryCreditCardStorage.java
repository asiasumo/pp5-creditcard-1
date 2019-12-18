package pl.uek.krakow.pp5.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.uek.krakow.pp5.services.CreditCardStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@NoArgsConstructor
public class InMemoryCreditCardStorage implements CreditCardStorage {
	private ConcurrentHashMap<String, CreditCard> cards;

	@Override
	public CreditCard load(String creditCardNumber) {
		return cards.get(creditCardNumber);
	}

	@Override
	public void add(CreditCard card) {
		cards.put(card.getCardNumber(), card);
	}

	@Override
	public List<CreditCard> all() {
		return new ArrayList<>(cards.values());
	}
}
