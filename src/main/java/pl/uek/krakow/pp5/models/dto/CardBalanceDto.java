package pl.uek.krakow.pp5.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CardBalanceDto {
	public String cardNumber;
	public BigDecimal balance;
}
