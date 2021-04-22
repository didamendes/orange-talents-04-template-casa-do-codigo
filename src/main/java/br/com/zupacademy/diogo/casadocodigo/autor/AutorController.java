package br.com.zupacademy.diogo.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok(new AutorResponse(autor));
    }

}
