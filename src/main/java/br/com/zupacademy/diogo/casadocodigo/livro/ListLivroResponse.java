package br.com.zupacademy.diogo.casadocodigo.livro;

import br.com.zupacademy.diogo.casadocodigo.autor.Autor;

import java.util.List;
import java.util.stream.Collectors;

public class ListLivroResponse {

    private Long id;

    private String titulo;

    public ListLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListLivroResponse> listsLivrosResponse(List<Livro> autores) {
       return autores.stream().map(ListLivroResponse::new).collect(Collectors.toList());
    }
}
