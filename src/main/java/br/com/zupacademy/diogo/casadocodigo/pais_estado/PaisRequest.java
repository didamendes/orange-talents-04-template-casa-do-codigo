package br.com.zupacademy.diogo.casadocodigo.pais_estado;

import br.com.zupacademy.diogo.casadocodigo.validator.ValidatorUnico;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @ValidatorUnico(classes = Pais.class, campo = "nome", message = "Pais já existe")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
