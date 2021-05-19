package br.com.zup.cineminha.compras;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteIdValidator implements ConstraintValidator<ExisteId, Long> {

    @PersistenceContext
    private EntityManager em;


    private Class<?> entidade;
    private String atributo;

    @Override
    public void initialize(ExisteId anotacao) {
        this.entidade = anotacao.entidade();
        this.atributo = anotacao.atributo();
    }

    @Override
    public boolean isValid(Long valor, ConstraintValidatorContext context) {

        Query query = em.createQuery("select 1 from " + entidade.getName() +
                                     " where " + atributo + " = :id");

        query.setParameter("id", valor);

        List<?> resultado = query.getResultList();

        return !resultado.isEmpty();

    }
}
