package fr.kira.formation.reactive.utilisateurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * Configuration pour le domaine des utilisateurs.
 * Initialise la table utilisateurs.
 */
@Configuration
public class UtilisateurConfiguration {

    /**
     * Initialise la table utilisateurs grâce au client R2DBC qui se connecte à la base de données.
     * @param client Le client R2DBC qui se connecte à la base de données.
     */
    @Autowired
    public void initTable(DatabaseClient client){
        String sql = """
                DROP TABLE IF EXISTS utilisateur;
                CREATE TABLE IF NOT EXISTS utilisateur (
                    id INT AUTO_INCREMENT,
                    username VARCHAR(32),
                    password VARCHAR(128),
                    email VARCHAR(64),
                    date DATETIME,
                    PRIMARY KEY (id)
                );
                """;
        client.sql(sql).then().subscribe();
    }
}
