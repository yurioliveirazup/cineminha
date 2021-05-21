package br.com.zup.cineminha.ingressos;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalTime horario;

    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Filme filme;

    private BigDecimal preco;

    /**
     * @deprecated hibernate apenas
     */
    @Deprecated
    public Sessao() {}

    public Sessao(LocalTime horario,
                  Sala sala,
                  Filme filme,
                  BigDecimal preco) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
