package fr.kira.formation.reactive.utilisateurs;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * Repository pour les utilisateurs {@link Utilisateur}.
 *
 * {@link R2dbcRepository} permet de créer des repository pour les entités en utilisant le driver R2DBC.
 */
public interface UtilsiateurRepository extends R2dbcRepository<Utilisateur, Long> {
}
