package com.bcopstein.Emprestimos;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private CalculoDeJuros calcJuros;
    public EmprestimoController(CalculoDeJuros calcJuros){
        this.calcJuros = calcJuros;
    }

    @GetMapping("/jurosSimples")
    @CrossOrigin(origins = "*")
    public EmprestimoDTO emprestimoJurosSimples(
            @RequestParam final Double valor,
            @RequestParam final Integer parcelas,
            @RequestParam final Double taxa){
        
        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                                    .valor(valor)
                                    .taxa(taxa)
                                    .parcelas(parcelas)
                                    .jurosSimples()
                                    .build();

        double valorParcela = emprestimo.custoTotal() / emprestimo.getNroParcelas();

        EmprestimoDTO resp = new EmprestimoDTO(
                                    emprestimo.isSegurado(),
                                    emprestimo.isJurosCompostos(), 
                                    emprestimo.getValor(),
                                    emprestimo.getTaxa(),
                                    emprestimo.getNroParcelas(),
                                    emprestimo.custoTotal(),
                                    valorParcela);
        return resp;
    }

    @GetMapping("/jurosCompostos")
    @CrossOrigin(origins = "*")
    public EmprestimoDTO emprestimoJurosCompostos(
            @RequestParam final Double valor,
            @RequestParam final Integer parcelas,
            @RequestParam final Double taxa){
        
        Emprestimo emprestimo = new Emprestimo.Builder(calcJuros)
                                    .valor(valor)
                                    .taxa(taxa)
                                    .parcelas(parcelas)
                                    .jurosCompostos()
                                    .build();

        double valorParcela = emprestimo.custoTotal()/emprestimo.getNroParcelas();

        EmprestimoDTO resp = new EmprestimoDTO(
                                    emprestimo.isSegurado(),
                                    emprestimo.isJurosCompostos(), 
                                    emprestimo.getValor(),
                                    emprestimo.getTaxa(),
                                    emprestimo.getNroParcelas(),
                                    emprestimo.custoTotal(),
                                    valorParcela);
        return resp;
    }
}

