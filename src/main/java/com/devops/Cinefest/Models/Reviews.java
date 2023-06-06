//models
package com.devops.Cinefest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    private ObjectId id;
    private String body;
    private String imbId;

    public Reviews(String body, String imbId) {
        this.body = body;
        this.imbId = imbId;
    }

    public Reviews(String body) {
        this.body = body;
    }
}
