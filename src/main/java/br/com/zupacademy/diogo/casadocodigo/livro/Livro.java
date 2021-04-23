package br.com.zupacademy.diogo.casadocodigo.livro;

import br.com.zupacademy.diogo.casadocodigo.autor.Autor;
import br.com.zupacademy.diogo.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "resumo", nullable = false, length = 500)
    private String resumo;

    @Column(name = "sumario", length = 2000)
    private String sumario;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "paginas", nullable = false)
    private Integer paginas;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 Integer paginas, String isbn, LocalDate dataPublicacao,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
