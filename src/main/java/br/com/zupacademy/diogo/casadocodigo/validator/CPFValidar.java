package br.com.zupacademy.diogo.casadocodigo.validator;

import br.com.caelum.stella.validation.CPFValidator;

public class CPFValidar  implements Validar {
    @Override
    public boolean validar(String value) {
        try {
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
