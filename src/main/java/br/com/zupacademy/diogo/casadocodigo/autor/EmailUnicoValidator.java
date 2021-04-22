package br.com.zupacademy.diogo.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValido = true;

        if (value != null && !value.isEmpty()) {
            isValido = autorRepository.existsByEmail(value);

            if (isValido) {
                return false;
            }
        }

        return true;
    }
}
