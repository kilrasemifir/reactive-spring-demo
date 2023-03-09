package fr.kira.formation.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * Configuration de la base de données.
 */
@Configuration
public class DbConfiguration {

    private static final String sql = """
            CREATE TABLE IF NOT EXISTS article (
                id INT AUTO_INCREMENT,
                contenu TEXT,
                date_creation DATETIME,
                PRIMARY KEY (id)
            );
            CREATE TABLE IF NOT EXISTS commentaire (
                id INT AUTO_INCREMENT,
                contenu TEXT,
                date_creation DATETIME,
                article_id INT,
                PRIMARY KEY (id),
                FOREIGN KEY (article_id) REFERENCES article(id)
            );
            """;

    @Autowired
    public void initSchema(DatabaseClient client) {
        client.sql(sql).then().subscribe();
    }
}
