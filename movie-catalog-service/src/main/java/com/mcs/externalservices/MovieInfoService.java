package com.mcs.externalservices;

import com.mcs.model.Movies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MOVIE-INFO-SERVICE", url = "http://localhost:8082/movies/")
public interface MovieInfoService {

    @GetMapping("/{movieId}")
    public Movies getMovieInfo(@PathVariable("movieId") String movieId);

}
