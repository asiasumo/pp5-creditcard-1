package pl.uek.krakow.pp5.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CardBalanceDto {
	public String cardNumber;
	public BigDecimal balance;
}
