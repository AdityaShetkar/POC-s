package com.mis.controller;

import com.mis.model.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public Movies getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movies(movieId, "Test Name");
    }
}
