package br.com.zupacademy.diogo.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> salvar(@Valid @RequestBody LivroRequest livroRequest) {
        Livro livro = livroRequest.converter(entityManager);
        entityManager.persist(livro);

        return ResponseEntity.ok(new LivroResponse(livro));
    }

}
