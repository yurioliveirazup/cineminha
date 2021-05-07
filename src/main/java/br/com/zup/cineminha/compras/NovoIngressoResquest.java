package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.Ingresso;
import br.com.zup.cineminha.ingressos.Sessao;
import br.com.zup.cineminha.ingressos.SessaoRepository;
import br.com.zup.cineminha.ingressos.Tipo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class NovoIngressoResquest {

    @NotNull
    @Positive
    private Long sessaoId; // valida se sessão existe ou não

    @NotNull
    private Tipo tipo;

    public Long getSessaoId() {
        return sessaoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Ingresso paraIngresso(SessaoRepository sessaoRepository) {
        Optional<Sessao> possivelSessao = sessaoRepository.findById(sessaoId);

        Sessao sessao = possivelSessao.get();

        return new Ingresso(sessao, tipo);
    }
}
