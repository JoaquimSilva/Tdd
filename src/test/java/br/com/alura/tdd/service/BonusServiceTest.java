package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    private BonusService service;
    private Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        this.service = new BonusService();
        this.funcionario = new Funcionario(
                "Washington Creiton", LocalDate.now(), new BigDecimal("25000"));
        BigDecimal bonus = service.calcularBonus(this.funcionario);
    }


    @Test
    void bonusDeveRetornarErroParaSalariosAcimaDe10000() {

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(this.funcionario));
    }

    @Test
    void bonusDeveRetornar10CentoParaOFuncionário() {

        BigDecimal bonus = service.calcularBonus(this.funcionario);
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeAté10000() {

        BigDecimal bonus = service.calcularBonus(this.funcionario);
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}