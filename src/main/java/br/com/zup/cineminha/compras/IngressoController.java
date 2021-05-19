package br.com.zup.cineminha.compras;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ingressos")
public class IngressoController {


    @PostMapping
    public String compra(@RequestBody @Valid NovoIngressoRequest novoIngresso) {

        System.out.println(novoIngresso);

        return "Olá, mundo!";
    }

}
