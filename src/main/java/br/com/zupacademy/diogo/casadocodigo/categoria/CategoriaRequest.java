package br.com.zupacademy.diogo.casadocodigo.categoria;

import br.com.zupacademy.diogo.casadocodigo.validator.ValidatorUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @ValidatorUnico(campo = "nome", classes = Categoria.class, message = "Categoria já existente")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}
