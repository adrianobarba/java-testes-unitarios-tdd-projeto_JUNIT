package br.com.adrianobarbosa.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.adrianobarbosa.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service= new BonusService();
		
		//1-Forma de excessão mais simples
		//assertThrows(IllegalArgumentException.class,
				//() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
		
		//2-Forma de excessão para capturar a mensagem 
		try {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception!");
		} catch (Exception e) {
			assertEquals("Funcionario com salário maior que R$10.000 não pode receber bonus!", e.getMessage());
		}
	
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service =  new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalarioDeExatamente10000() {
		BonusService service =  new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
