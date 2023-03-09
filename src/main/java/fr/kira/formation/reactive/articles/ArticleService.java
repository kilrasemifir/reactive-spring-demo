package fr.kira.formation.reactive.articles;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.reactive.commentaires.Commentaire;
import fr.kira.formation.reactive.commentaires.CommentaireService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentaireService commentaireService;

    private final ObjectMapper mapper;

    public ArticleService(ArticleRepository articleRepository, CommentaireService commentaireService, ObjectMapper mapper) {
        this.articleRepository = articleRepository;
        this.commentaireService = commentaireService;
        this.mapper = mapper;
    }

    public Mono<Article> save(Article entity) {
        return articleRepository.save(entity);
    }

    private static Article toDtoWithComs(Article article, List<Commentaire> commentaires){
        ArticleDto dto = new ArticleDto();
        dto.setId(article.getId());
        dto.setTitre(article.getTitre());
        dto.setCommentaires(commentaires);
        dto.setContenu(article.getContenu());
        return  dto;
    }

    public Mono<Article> findById(Long aLong) {
        Mono<Article> article = articleRepository.findById(aLong);
        Flux<Commentaire> commentaires = commentaireService.findByArticleId(aLong);
        return article.zipWith(
                commentaires.collectList(),
                (atc, coms) -> {
                    ArticleDto dto = mapper.convertValue(atc, ArticleDto.class);
                    dto.setCommentaires(coms);
                    return  dto;
                });
    }

    public Mono<Void> deleteById(Long aLong) {
        return articleRepository.deleteById(aLong);
    }

    public Flux<Article> findAll() {
        return articleRepository.findAll();
    }
}
