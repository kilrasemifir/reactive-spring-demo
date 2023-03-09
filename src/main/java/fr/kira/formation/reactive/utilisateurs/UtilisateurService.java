package fr.kira.formation.reactive.utilisateurs;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UtilisateurService {

    private final UtilsiateurRepository utilisateurRepository;

    public UtilisateurService(UtilsiateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Mono<Utilisateur> save(Utilisateur entity) {
        return utilisateurRepository.save(entity);
    }

    public Mono<Utilisateur> findById(Long aLong) {
        return utilisateurRepository.findById(aLong);
    }

    public Flux<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Mono<Void> deleteById(Long aLong) {
        return utilisateurRepository.deleteById(aLong);
    }


}
