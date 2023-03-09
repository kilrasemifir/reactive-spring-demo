package fr.kira.formation.reactive.commentaires;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;

    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public Mono<Commentaire> save(Commentaire entity) {
        return commentaireRepository.save(entity);
    }

    public Mono<Commentaire> findById(Long id) {
        return commentaireRepository.findById(id);
    }

    public Flux<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    public Mono<Void> deleteById(Long id) {
        return commentaireRepository.deleteById(id);
    }

    public Flux<Commentaire> findByArticleId(Long articleId) {
        return commentaireRepository.findByArticleId(articleId);
    }
}
