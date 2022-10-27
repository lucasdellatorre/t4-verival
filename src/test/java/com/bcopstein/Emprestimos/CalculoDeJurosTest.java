package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculoDeJurosApplicationTets {
	@Autowired
	private CalculoDeJuros calcJuros;

	@BeforeAll
	public void setup() {
		calcJuros = new CalculoDeJuros();
	} 
	@Test
	public void test1() {
		assertThat(true).isTrue();
	}
}

