package com.mcs.controller;

import com.mcs.externalservices.MovieInfoService;
import com.mcs.externalservices.RatingDataService;
import com.mcs.model.CatalogItems;
import com.mcs.model.Movies;
import com.mcs.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RatingDataService ratingDataService;

    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping("/{userId}")
    public List<CatalogItems> getAllItems(@PathVariable("userId") String userId){

       // UserRating ratings = restTemplate.getForObject("http://rating-data-service/rating/users/" + userId, UserRating.class);
        UserRating ratings = ratingDataService.getlistRating(userId);
        return ratings.getUsertaings()
                .stream()
                .map(rating ->{
                        //For each movie ID, call movie info service and get details
//                        Movies movies = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movies.class);
                    Movies movies = movieInfoService.getMovieInfo(userId);
//                         Movies movies = webClientBuilder.build()
//                                .get()
//                                .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                                .retrieve()
//                                .bodyToMono(Movies.class)
//                                .block();
                        //Put them all together
                        return new CatalogItems(movies.getMovieName(), "Desc", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
