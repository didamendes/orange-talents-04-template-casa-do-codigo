package br.com.zupacademy.diogo.casadocodigo.pais_estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoResponse> salvar(@RequestBody @Valid EstadoRequest estadoRequest) throws Exception {
        Long count = estadoRepository.estadoExisteNoPais(estadoRequest.getNome(), estadoRequest.getIdPais());

        if (count > BigDecimal.ZERO.longValue()) {
            throw new Exception("Estado já existente no país informado.");
        }

        Estado estado = estadoRequest.converter(paisRepository);
        estadoRepository.save(estado);

        return ResponseEntity.ok(new EstadoResponse(estado));
    }

}
