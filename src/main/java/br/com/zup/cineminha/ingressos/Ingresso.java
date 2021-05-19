package br.com.zup.cineminha.ingressos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Vector;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Sessao sessao;

    @PastOrPresent
    private LocalDateTime horaDaCompra = LocalDateTime.now();

    @Positive
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;


    /**
     * @deprecated para uso do hibernate
     */
    @Deprecated
    public Ingresso() { }

    public Ingresso(Sessao sessao, Tipo tipo) {
        this.sessao = sessao;

        if (sessao.getPreco().compareTo(BigDecimal.ZERO) == 0) {
            this.tipo = Tipo.CORTESIA;
        } else {
            this.tipo = tipo;
        }

        this.preco = tipo.calcula(sessao.getPreco());
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
