package fr.uga.l3miage.photonum.tirage;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record TirageDTO(
        @NotBlank(message = "impression's id is mandatory")
        String id,
        int prix,
        Catalogue reference,
        Article article,
        Set<Photo> photos
){}
