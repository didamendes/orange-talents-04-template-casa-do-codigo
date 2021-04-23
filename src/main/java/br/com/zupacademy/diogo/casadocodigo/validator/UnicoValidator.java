package br.com.zupacademy.diogo.casadocodigo.validator;

import br.com.zupacademy.diogo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.diogo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.diogo.casadocodigo.categoria.CategoriaUnica;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UnicoValidator implements ConstraintValidator<ValidatorUnico, Object> {

    private String campo;
    private Class<?> classes;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ValidatorUnico constraintAnnotation) {
        campo = constraintAnnotation.campo();
        classes = constraintAnnotation.classes();
    }

    @Override
    public boolean isValid(Object valor, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + classes.getName() + " WHERE " + campo +"=:value");
        query.setParameter("value", valor);
        List list = query.getResultList();

        if (!list.isEmpty()) {
            return false;
        }

        return true;
    }
}
