package br.com.zupacademy.diogo.casadocodigo.validator;

import br.com.caelum.stella.validation.CNPJValidator;

public class CNPJValidar implements Validar {
    @Override
    public boolean validar(String value) {
        try {
            CNPJValidator cnpjValidator = new CNPJValidator();
            cnpjValidator.assertValid(value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
