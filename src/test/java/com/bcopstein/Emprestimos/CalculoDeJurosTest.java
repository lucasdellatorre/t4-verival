package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoDeJurosTest {

	private CalculoDeJuros calcJuros;

	@BeforeEach
	public void setup() {
		calcJuros = new CalculoDeJuros();
	}

	@Test
	void jurosEmprestimoJurosSimplesComSeguro() {
		double resultado = calcJuros.jurosEmprestimoJurosSimples(1000,0.032,10);
		assertEquals(resultado,420);
	}

	@Test
	void jurosEmprestimoJurosSimplesSemSeguro() {
		calcJuros.setSeguro(false);
		double resultado = calcJuros.jurosEmprestimoJurosSimples(1000,0.032,10);
		assertEquals(resultado,320);
	}

	@Test
	void jurosEmprestimoJurosCompostosComSeguro() {
		double resultado = calcJuros.jurosEmprestimoJurosCompostos(1000,0.032,10);
		assertEquals(resultado,508.9581311516531);
	}

	@Test
	void jurosEmprestimoJurosCompostosSemSeguro() {
		calcJuros.setSeguro(false);
		double resultado = calcJuros.jurosEmprestimoJurosCompostos(1000,0.032,10);
		assertEquals(resultado,370.2410463356464);
	}
}

