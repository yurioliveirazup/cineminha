package br.com.zup.cineminha.compras;

import br.com.zup.cineminha.ingressos.Sessao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ExisteIdValidator.class })
public @interface ExisteId {

    String message() default "id nao existente";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> entidade();

    String atributo();
}
