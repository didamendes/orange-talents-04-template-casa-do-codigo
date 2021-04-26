package br.com.zupacademy.diogo.casadocodigo.cliente;

import br.com.zupacademy.diogo.casadocodigo.pais_estado.Estado;
import br.com.zupacademy.diogo.casadocodigo.pais_estado.Pais;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "complemento", nullable = false)
    private String complemento;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cep", nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Deprecated
    public Cliente() {}

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco,
                   String complemento, String cidade, String telefone, String cep,
                   Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco,
                   String complemento, String cidade, String telefone, String cep,
                   Pais pais, Estado estado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }
}
