package fr.kira.formation.reactive.articles;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Table(name = "article")
public class Article {
    @Id
    private Long id;
    private String titre;
    private String contenu;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation = LocalDateTime.now();
}
