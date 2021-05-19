package br.com.zup.cineminha.ingressos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

class IngressoTest {

    private Filme filme;
    private Sala sala;

    @BeforeEach
    public void setup() {
        this.filme = new Filme("Harry Potter", Duration.ofHours(1));
        this.sala = new Sala("OT4");
    }

    // quando ingresso for INTEIRA

    // deveFazerAlgumaCoisaQuandoTalCoisaOcorrer
    // quandoTalCoisaOcorrerDeveFazerAlgumaCoisa
    // quandoTalCoisaOcorrer_deveFazerAlgumaCoisa

    @Test
    public void deveSerIgualAZeroETipoSerCortesiaQuandoASessaoTiverValorZero() {
        Sessao sessao = new Sessao(LocalTime.now(), sala, filme, BigDecimal.ZERO);

        Ingresso ingresso = new Ingresso(sessao, Tipo.INTEIRA);

        Assertions.assertEquals(BigDecimal.ZERO, ingresso.getPreco());
        Assertions.assertEquals(Tipo.CORTESIA, ingresso.getTipo());
    }


    @Test
    public void deveManterOTipoQuandoASessaoNaoTiverValorZero() {
        Sessao sessao = new Sessao(LocalTime.now(), sala, filme, BigDecimal.ONE);
        Ingresso ingresso = new Ingresso(sessao, Tipo.INTEIRA);

        Assertions.assertEquals(Tipo.INTEIRA, ingresso.getTipo());
    }

}