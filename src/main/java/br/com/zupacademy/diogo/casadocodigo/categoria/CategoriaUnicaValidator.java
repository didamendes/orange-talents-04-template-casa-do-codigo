package br.com.zupacademy.diogo.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriaUnicaValidator implements ConstraintValidator<CategoriaUnica, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(CategoriaUnica constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValido = true;

        if (value != null && !value.isEmpty()) {
            isValido = categoriaRepository.existsByNome(value);

            if (isValido) {
                return false;
            }
        }

        return true;
    }
}
