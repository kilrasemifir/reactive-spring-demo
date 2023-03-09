package fr.kira.formation.reactive.commentaires;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CommentaireRepository extends R2dbcRepository<Commentaire, Long> {

    Flux<Commentaire> findByArticleId(Long articleId);
}
