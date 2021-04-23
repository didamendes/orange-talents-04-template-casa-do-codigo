package br.com.zupacademy.diogo.casadocodigo.livro;

import br.com.zupacademy.diogo.casadocodigo.autor.Autor;
import br.com.zupacademy.diogo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.diogo.casadocodigo.validator.ValidatorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @ValidatorUnico(classes = Livro.class, campo = "titulo", message = "Titulo já cadastrado")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Size(max = 2000)
    private String sumario;

    @NotNull
    @DecimalMin(value = "50")
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    @ValidatorUnico(classes = Livro.class, campo = "isbn", message = "ISBN já cadastrado")
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @FutureOrPresent
    private LocalDate dataPublicacao;

    @NotNull
    public Long idCategoria;

    @NotNull
    private Long idAutor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro converter(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, this.idCategoria);
        Autor autor = entityManager.find(Autor.class, this.idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas,
                this.isbn, this.dataPublicacao, categoria, autor);
    }

}
