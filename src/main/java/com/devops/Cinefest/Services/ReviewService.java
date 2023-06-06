package com.devops.Cinefest.Services;

import com.devops.Cinefest.Models.Movies;
import com.devops.Cinefest.Models.Reviews;
import com.devops.Cinefest.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private MongoTemplate mtemplate;    // to do complex operations without repository

    public ReviewService(MongoTemplate mtemplate) {
        this.mtemplate = mtemplate;
    }

    public Reviews createReview(String reviewBody, String imdbId) {
        Reviews rev = reviewRepo.insert(new Reviews(reviewBody, imdbId));

        // using template to update movie document
        mtemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(rev))
                .first();

        return rev;
    }
}
