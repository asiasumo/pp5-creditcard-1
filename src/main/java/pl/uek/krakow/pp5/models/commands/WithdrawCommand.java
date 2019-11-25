package pl.uek.krakow.pp5.models.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class WithdrawCommand {
	public String cardNumber;
	public BigDecimal withdrawAmount;
}
