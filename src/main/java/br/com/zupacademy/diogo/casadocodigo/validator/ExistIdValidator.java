package br.com.zupacademy.diogo.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    private String campo;
    private Class<?> classes;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        campo = constraintAnnotation.campo();
        classes = constraintAnnotation.classes();
    }

    @Override
    public boolean isValid(Object valor, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + classes.getName() + " WHERE " + campo +"=:value");
        query.setParameter("value", valor);
        List list = query.getResultList();

        if (list.isEmpty()) {
            return false;
        }

        return true;
    }
}
