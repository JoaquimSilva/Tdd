package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteServices {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percent = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percent);
        funcionario.reajustarSalario(reajuste);
    }
}
