package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/ingressos")
public class IngressoController {

    private final SessaoRepository sessaoRepository;

    private final IngressoRepository ingressoRepository;

    public IngressoController(SessaoRepository sessaoRepository,
                              IngressoRepository ingressoRepository) {

        this.sessaoRepository = sessaoRepository;
        this.ingressoRepository = ingressoRepository;
    }

    @PostMapping
    public ResponseEntity<?> compra(@RequestBody @Valid NovoIngressoRequest novoIngresso,
                                    UriComponentsBuilder uriBuilder) {

        Ingresso ingresso = novoIngresso.toModel(sessaoRepository);

        ingressoRepository.save(ingresso);

        URI location = uriBuilder.path("/api/ingressos/{id}")
                                 .buildAndExpand(ingresso.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();
    }

}
