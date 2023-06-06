// models
package com.devops.Cinefest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movies")
@Data   //Annotation for inbuilt getters & setters of each data and toString method
@AllArgsConstructor //Annotation for constructor that takes all datafields as arguments
@NoArgsConstructor  //Constructor with no arguments
public class Movies {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DBRef
    private List<String> reviewIds;
    private List<Reviews> reviews;

    public Movies(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> genres, List<String> backdrops) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.genres = genres;
        this.backdrops = backdrops;
    }
}


//    @DocumentReference  //instructs DB to store only IDs of reviews & reviews in separate collection instead of embedded relationships
