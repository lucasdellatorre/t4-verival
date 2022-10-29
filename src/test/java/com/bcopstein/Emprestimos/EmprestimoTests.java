package com.bcopstein.Emprestimos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmprestimoTests {
    @Mock private CalculoDeJuros calcJuros;

    @Test
    public void testDefaultValues() {
        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                .build();

        assertEquals(emprestimo.getValor(), 1000.0);
        assertEquals(emprestimo.getNroParcelas(), 5);
        assertEquals(emprestimo.getTaxa(), 0.035);
        assertEquals(emprestimo.isJurosCompostos(), true);
        assertEquals(emprestimo.isSegurado(), true);
    }

    @Test
    public void testCustoTotalComJurosCompostos() {
        double resEsp, resObs;

        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                .jurosCompostos()
                .valor(10)
                .taxa(0.030)
                .parcelas(3)
                .build();

        when(calcJuros.jurosEmprestimoJurosCompostos(10, 0.030, 3)).thenReturn(1.24864);

        resEsp = 10.6 + 1.24864; // valor da conta
        resObs = emprestimo.custoTotal();

        Assertions.assertEquals(resObs, resEsp);
    }

    @Test
    public void testCustoTotalSemJurosCompostos() {
        double resEsp, resObs;

        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                .jurosSimples()
                .valor(20)
                .taxa(0.030)
                .parcelas(4)
                .build();

        when(calcJuros.jurosEmprestimoJurosSimples(20, 0.030, 4)).thenReturn(3.2);

        resEsp = 21.2 + 3.2; // valor da conta
        resObs = emprestimo.custoTotal();

        Assertions.assertEquals(resObs, resEsp);
    }

    @Test
    public void testValorParcela() {
        double resEsp, resObs;

        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                .jurosSimples()
                .valor(20)
                .taxa(0.030)
                .parcelas(4)
                .build();

        when(calcJuros.jurosEmprestimoJurosSimples(20, 0.030, 4)).thenReturn(3.2);

        // 21.2 + 3.2;
        resEsp = 6.1; // valor da conta
        resObs = emprestimo.valorParcela();

        Assertions.assertEquals(resObs, resEsp);
    }
}