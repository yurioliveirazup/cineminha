package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.Sessao;
import br.com.zup.cineminha.ingressos.SessaoRepository;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;
import java.util.StringJoiner;

public class NovoIngressoRequest {

    @NotNull
    @Positive
    @ExisteId(entidade = Sessao.class, atributo = "id")
    private Long sessaoId;

    @NotNull
    private Tipo tipo; // INTEIRA || MEIA_ENTRADA

    @NotBlank
    @CPF
    private String documento;

    public NovoIngressoRequest(Long sessaoId,
                               Tipo tipo,
                               String documento) {
        this.sessaoId = sessaoId;
        this.tipo = tipo;
        this.documento = documento;
    }


    public Ingresso toModel(SessaoRepository sessaoRepository) {
        Optional<Sessao> possivelSessao = sessaoRepository.findById(sessaoId);

        if (possivelSessao.isEmpty()) {
            throw new IllegalStateException("sessaoId nao cadastrado");
        }

        Sessao sessao = possivelSessao.get();

        return new Ingresso(tipo, documento, sessao);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NovoIngressoRequest.class.getSimpleName() + "[", "]")
                .add("sessaoId=" + sessaoId)
                .add("tipo=" + tipo)
                .add("documento='" + documento + "'")
                .toString();
    }
}
