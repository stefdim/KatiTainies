package com.assignment.movies.controllers;

import com.assignment.movies.entities.Movie;
import com.assignment.movies.services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("movies")
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

     @GetMapping("/allmovies")
    public String getMovies(Model model) {
         List<Movie> movies = service.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }
    
    @GetMapping(value = "/movieDetails/{movieId}")
    public String getMovieDetails(@PathVariable("movieId") Long movieId, Model model) {
        Movie movieDetails = service.getById(movieId);
        model.addAttribute("movieDetails", movieDetails);
        return "moviedetails";
    }
    
    @GetMapping("/watch")
    public String watchMovie(){
        return "watchmovie";
    }

}
