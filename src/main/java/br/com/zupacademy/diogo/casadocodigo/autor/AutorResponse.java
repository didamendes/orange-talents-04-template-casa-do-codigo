package br.com.zupacademy.diogo.casadocodigo.autor;

import java.time.OffsetDateTime;

public class AutorResponse {

    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private OffsetDateTime dataCriacao;

    public AutorResponse (Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }
}
