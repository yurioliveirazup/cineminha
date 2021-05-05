package br.com.zup.cineminha.ingressos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Ingresso {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Sessao sessao;

    private LocalDateTime horaDaCompra;

    private BigDecimal preco;

    private Tipo tipo;


}
