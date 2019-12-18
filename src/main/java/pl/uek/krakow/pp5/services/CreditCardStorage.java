package pl.uek.krakow.pp5.services;

import pl.uek.krakow.pp5.models.CreditCard;

import java.util.List;

public interface CreditCardStorage {
	CreditCard load(String creditCardNumber);

	void add(CreditCard card);

	List<CreditCard> all();
}
