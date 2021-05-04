package br.com.zup.cineminha.ingressos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Duration;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private Duration duracao;

    /**
     * @deprecated hibernate apenas
     */
    public Filme() { }

    public Filme(String nome,
                 Duration duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }
}
