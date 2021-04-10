package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServicesTest {

    private ReajusteServices reajuste;
    private Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        this.reajuste = new ReajusteServices();
        this.funcionario = new Funcionario(
                "Washington Creiton", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void reajusteDeApenas3PorCentoQuandoDesempendoForADesejar() {

        reajuste.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeApenas15PorCentoQuandoDesempendoForBom() {


        reajuste.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeApenas20PorCentoQuandoDesempendoForOtimo() {

        reajuste.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}