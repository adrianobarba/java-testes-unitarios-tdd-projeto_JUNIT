package br.com.adrianobarbosa.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.adrianobarbosa.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario com salário maior que R$10.000 não pode receber bonus!");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
