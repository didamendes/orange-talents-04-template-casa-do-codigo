package br.com.zupacademy.diogo.casadocodigo.validator;

import br.com.caelum.stella.validation.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfORCnpjValidator implements ConstraintValidator<CpfORCnpj, String> {
    @Override
    public void initialize(CpfORCnpj constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Boolean valido = Boolean.TRUE;
        Validar cpf = new CPFValidar();
        Validar cnpj = new CNPJValidar();

        if (value.length() == 11) {
            valido = cpf.validar(value);
        } else {
            valido = cnpj.validar(value);
        }
        return valido;
    }
}
