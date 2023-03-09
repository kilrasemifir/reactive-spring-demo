package fr.kira.formation.reactive.utilisateurs;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public Mono<Utilisateur> save(@RequestBody Utilisateur entity) {
        return utilisateurService.save(entity);
    }

    @GetMapping("{id}")
    public Mono<Utilisateur> findById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @GetMapping
    public Flux<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return utilisateurService.deleteById(id);
    }
}
