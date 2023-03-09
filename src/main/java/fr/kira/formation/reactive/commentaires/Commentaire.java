package fr.kira.formation.reactive.commentaires;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Table(name = "commentaire")
public class Commentaire {

    @Id
    private Long id;
    private String contenu;
    private Long articleId;
    @Column(name="date_creation")
    private LocalDateTime dateCreation = LocalDateTime.now();
}
