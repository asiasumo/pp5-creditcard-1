package pl.uek.krakow.pp5.models;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CreditCard {
	@NonNull
	private final String cardNumber;
	@NonNull
	private BigDecimal limit;
	private BigDecimal balance;

	public void setLimit(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.valueOf(100)) < 0) {
			throw new IllegalStateException("Cannot set limit below 100 PLN");
		}
		limit = amount;
	}

	public void setBalance(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalStateException("Cannot set money below zero");
		}
		balance = amount;
	}

	public void withdraw(BigDecimal withdrawAmount) {
		if (withdrawAmount.compareTo(limit) > 0) {
			throw new IllegalStateException("Cannot withdraw above limit amount");
		}
		setBalance(balance.subtract(withdrawAmount));
	}

	public void deposit(BigDecimal amount) {
		setBalance(balance.add(amount));
	}

	public static CreditCard of(CreditCardData creditCard) {
		if (creditCard == null) return null;
		return CreditCard.builder()
				.cardNumber(creditCard.getCardNumber())
				.limit(creditCard.getLimit())
				.build();
	}
}
