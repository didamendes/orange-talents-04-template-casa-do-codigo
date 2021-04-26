package br.com.zupacademy.diogo.casadocodigo.pais_estado;

public class EstadoResponse {

    private Long id;

    private String nome;

    private Long idPais;

    private String nomePais;

    public EstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.idPais = estado.getPais().getId();
        this.nomePais = estado.getPais().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getNomePais() {
        return nomePais;
    }
}
