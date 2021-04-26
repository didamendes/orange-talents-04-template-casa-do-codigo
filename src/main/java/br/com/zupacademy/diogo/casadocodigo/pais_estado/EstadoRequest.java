package br.com.zupacademy.diogo.casadocodigo.pais_estado;

import br.com.zupacademy.diogo.casadocodigo.validator.ExistId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExistId(classes = Pais.class, campo = "id", message = "Pais não existe")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converter(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(idPais).get();
        return new Estado(nome, pais);
    }
}
