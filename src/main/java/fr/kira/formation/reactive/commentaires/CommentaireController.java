package fr.kira.formation.reactive.commentaires;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping
    public Flux<Commentaire> findAll() {
        return commentaireService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Commentaire> findById(@PathVariable Long id) {
        return commentaireService.findById(id);
    }

    @PostMapping
    public Mono<Commentaire> save(@RequestBody Commentaire entity) {
        return commentaireService.save(entity);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return commentaireService.deleteById(id);
    }
}
