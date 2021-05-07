package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.Ingresso;
import br.com.zup.cineminha.ingressos.IngressoRepository;
import br.com.zup.cineminha.ingressos.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private IngressoRepository ingressoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> compra(@RequestBody @Valid NovoIngressoResquest request,
                                    UriComponentsBuilder uriBuilder) {

        Ingresso novoIngresso = request.paraIngresso(sessaoRepository);

        ingressoRepository.save(novoIngresso);

        URI location = uriBuilder.path("/api/compras/{id}")
                                 .buildAndExpand(novoIngresso.getId())
                                 .toUri();
        // /api/compras/{id}

        return ResponseEntity.created(location).build();
    }

}
