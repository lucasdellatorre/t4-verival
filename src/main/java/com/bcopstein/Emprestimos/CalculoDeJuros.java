package com.bcopstein.Emprestimos;

import org.springframework.stereotype.Component;

@Component
public class CalculoDeJuros {
    public static final double TXSEGUROPADRAO = 0.01;
    private double txSeguro;
    private boolean comSeguro;

    public CalculoDeJuros() {
        this.txSeguro = TXSEGUROPADRAO;
        this.comSeguro = true;
    }

    public void setSeguro(boolean seguro) {
        this.comSeguro = seguro;
    }

    public boolean comSeguro() {
        return this.comSeguro;
    }

    public void setTaxaSeguro(double taxa){
        txSeguro = taxa;
    }

    public double getTaxaSeguro(){
        return txSeguro;
    }

    public double jurosEmprestimoJurosSimples(double valor, double taxa, int nroParcelas) {
        if (!isInputValid(valor, taxa, nroParcelas))
            return -1;
        if (comSeguro)
            return (valor * (taxa + txSeguro) * nroParcelas);
        
        return (valor * taxa * nroParcelas);
    }

    public double jurosEmprestimoJurosCompostos(double valor, double taxa, int nroParcelas) {
        if (!isInputValid(valor, taxa, nroParcelas)) 
            return -1;
        double tx = taxa;
        if (comSeguro){
            tx += txSeguro;
        }
        double valorAcum = valor;
        while (nroParcelas > 0) {
            valorAcum += valorAcum * tx;
            nroParcelas--;
        }
        return valorAcum - valor;
    }

    private boolean isInputValid(double v, double t, int n) {
        return v < 0 && t < 0 && n < 0;
    }
}
