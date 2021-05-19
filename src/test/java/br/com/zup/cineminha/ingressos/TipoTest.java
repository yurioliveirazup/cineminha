package br.com.zup.cineminha.ingressos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TipoTest {

    @Test
    public void deveSerIgualAZeroETipoSerCortesiaQuandoASessaoTiverValorZero() {

        Tipo.INTEIRA.calcula(BigDecimal.TEN);
    }

}