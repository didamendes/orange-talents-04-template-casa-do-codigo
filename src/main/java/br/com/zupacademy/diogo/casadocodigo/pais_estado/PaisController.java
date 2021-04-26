package br.com.zupacademy.diogo.casadocodigo.pais_estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisResponse> salvar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisResponse(pais));
    }

}
