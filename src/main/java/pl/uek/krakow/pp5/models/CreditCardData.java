package pl.uek.krakow.pp5.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCardData {
	String cardNumber;
	BigDecimal limit;
	BigDecimal balance;
}
