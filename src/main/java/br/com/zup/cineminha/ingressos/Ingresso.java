package br.com.zup.cineminha.ingressos;

import javax.persistence.*;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Sessao sessao;

    private BigDecimal preco = ZERO;

    private BigDecimal precoFinal = ZERO;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    /**
     * @deprecated hibernate apenas
     */
    @Deprecated
    public Ingresso() {}

    public Ingresso(Sessao sessao,
                    BigDecimal preco,
                    Tipo tipoDeIngresso) {

        this.sessao = sessao;
        this.preco = preco;

        this.tipo = tipoDeIngresso;
    }
}
