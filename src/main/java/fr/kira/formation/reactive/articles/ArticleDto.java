package fr.kira.formation.reactive.articles;

import fr.kira.formation.reactive.commentaires.Commentaire;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ArticleDto extends Article {

    private List<Commentaire> commentaires = new ArrayList<>();

    public int getNombreCommentaire(){
        return this.commentaires.size();
    }

    public LocalDateTime getDernierCommentaire(){
        LocalDateTime derniereDate = LocalDateTime.of(1,1,1,0,0);
        for (Commentaire commentaire: this.commentaires){
            if (derniereDate.isBefore(commentaire.getDateCreation())){
                derniereDate = commentaire.getDateCreation();
            }
        }
        return derniereDate;
    }
}
