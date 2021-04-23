package br.com.zupacademy.diogo.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        Livro livro = entityManager.find(Livro.class, id);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalheLivroResponse(livro));
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<ListLivroResponse>> todos() {
        TypedQuery<Livro> query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class);
        List<Livro> livros = query.getResultList();

        return ResponseEntity.ok(ListLivroResponse.listsLivrosResponse(livros));
    }

}
