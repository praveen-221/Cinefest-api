package com.devops.Cinefest.Services;

import com.devops.Cinefest.Models.Movies;
import com.devops.Cinefest.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepo;
    public List<Movies> allMovies() {
        List<Movies> ret = movieRepo.findAll();
        for(Movies m: ret) {
//            System.out.println("Backdrops: " + m.getBackdrops());
            System.out.println("Reviews: " + m.getReviews());
        }
        return ret;
    }

    public Optional<Movies> getSingleMovie(String imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
