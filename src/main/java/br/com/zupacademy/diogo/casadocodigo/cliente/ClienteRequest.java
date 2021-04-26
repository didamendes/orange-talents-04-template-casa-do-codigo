package br.com.zupacademy.diogo.casadocodigo.cliente;

import br.com.zupacademy.diogo.casadocodigo.pais_estado.Estado;
import br.com.zupacademy.diogo.casadocodigo.pais_estado.EstadoRepository;
import br.com.zupacademy.diogo.casadocodigo.pais_estado.Pais;
import br.com.zupacademy.diogo.casadocodigo.pais_estado.PaisRepository;
import br.com.zupacademy.diogo.casadocodigo.validator.CpfORCnpj;
import br.com.zupacademy.diogo.casadocodigo.validator.ExistId;
import br.com.zupacademy.diogo.casadocodigo.validator.ValidatorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ClienteRequest {

    @NotBlank
    @Email
    @ValidatorUnico(classes = Cliente.class, campo = "email", message = "Email já existente")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Size(min = 11, max = 14)
    @ValidatorUnico(classes = Cliente.class, campo = "documento", message = "Documento já existente")
    @CpfORCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotNull
    @ExistId(classes = Pais.class, campo = "id", message = "Pais não existente")
    private Long idPais;

    private Long idEstado;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
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

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public boolean isPais(EstadoRepository estadoRepository) {
        Long count = estadoRepository.countByPaisId(idPais);

        if (count > BigDecimal.ZERO.longValue()) {
            return true;
        }

        return false;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.findById(idPais).get();
        boolean exists = isPais(estadoRepository);

        if (exists) {
            if (getIdEstado() == null) {
                throw new IllegalArgumentException("Id estado não pode ser nulo");
            }

            Estado estado = estadoRepository.findById(idEstado).get();
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);
        }

        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais);
    }
}
