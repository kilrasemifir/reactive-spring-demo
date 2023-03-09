package fr.kira.formation.reactive.articles;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public Flux<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Article> findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping
    public Mono<Article> save(@RequestBody Article entity) {
        return articleService.save(entity);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return articleService.deleteById(id);
    }
}
