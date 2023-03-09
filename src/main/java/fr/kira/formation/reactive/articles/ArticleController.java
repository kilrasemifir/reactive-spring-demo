package fr.kira.formation.reactive.articles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation( summary = "Retourne la liste des articles sauvergardés dans la base de données" )
    @GetMapping
    public Flux<Article> findAll() {
        return articleService.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article trouvé"),
            @ApiResponse(responseCode = "404", description = "Aucun Article ne porte cet Id")
    })
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
