package br.com.zupacademy.diogo.casadocodigo.autor;

import br.com.zupacademy.diogo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.diogo.casadocodigo.validator.ValidatorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @ValidatorUnico(campo = "email", classes = Autor.class, message = "Email já existente")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }

}
