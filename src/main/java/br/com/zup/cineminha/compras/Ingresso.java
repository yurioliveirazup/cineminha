package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.Sessao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String documento;

    @ManyToOne
    private Sessao sessao;

    private BigDecimal preco;

    /**
     * @deprecated apenas para o hibernate
     */
    @Deprecated
    public Ingresso() { }


    public Ingresso(Tipo tipo, // MEIA_ENTRADA
                    String documento,
                    Sessao sessao) {
        this.tipo = tipo;
        this.documento = documento;
        this.sessao = sessao;

        // Polimorfismo
        this.preco = tipo.calcula(sessao.getPreco()); // MEIA_ENTRADA.calcula()
    }

    public Long getId() {
        return id;
    }
}
