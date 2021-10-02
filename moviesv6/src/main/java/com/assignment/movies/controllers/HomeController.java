package com.assignment.movies.controllers;

import com.assignment.movies.entities.Movie;
import com.assignment.movies.services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MovieService service;

    
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<Movie> movies = service.getAllMovies();
        model.addAttribute("movies", movies);
        
        List<Movie> moviesDate = service.listPerReleaseDate(10);
        model.addAttribute("moviesD", moviesDate);
        
        List<Movie> moviesRating = service.listPerImdbRating(10);
        model.addAttribute("moviesR", moviesRating);
        
        List<Movie> moviesPrice = service.listPerSellPrice(10);
        model.addAttribute("moviesP", moviesPrice);

        Movie movie = service.getById(1006L);
        model.addAttribute("oneMovie", movie);

        Movie movie2 = service.getById(1014L);
        model.addAttribute("oneMovie2", movie2);

        return "home";
    }

    
    
}
