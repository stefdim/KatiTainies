package com.assignment.movies.services;

import com.assignment.movies.entities.Movie;
import com.assignment.movies.repositories.MovieRepository;
import java.util.List;
import javax.transaction.Transactional;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Node.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
    
    @Autowired
    private MovieRepository repository;
    
    public List<Movie> getAllMovies(){
       return repository.findAll();
    }
    
    public Movie getById(Long id){
        return repository.getById(id);
    }
    
    public boolean insertMovie(Movie movie){
        return repository.save(movie).getMovieId() >0 ;
    }
    
    public boolean findById(Long id){
        return (repository.findById(id).get().getMovieId() > 0);
    }
    
    public boolean deleteById(Long id){
        repository.deleteById(id);
        return true;
    }
    
    public boolean updateMovie(Movie movie){
        Movie copy = repository.findById(movie.getMovieId()).get();
        copy.setBoxOffice(movie.getBoxOffice());
        copy.setBudget(movie.getBudget());
        copy.setCast(movie.getCast());
        copy.setCompanies(movie.getCompanies());
        copy.setDirector(movie.getDirector());
        copy.setDuration(movie.getDuration());
        copy.setGenres(movie.getGenres());
        copy.setLanguages(movie.getLanguages());
        copy.setLogo(movie.getLogo());
        copy.setReleaseDate(movie.getReleaseDate());
        copy.setSellPrice(movie.getSellPrice());
        copy.setSummary(movie.getSummary());
        copy.setTitle(movie.getTitle());
        copy.setTrailerUrl(movie.getTrailerUrl());
        repository.saveAndFlush(copy);
        return true;
    }
    
    public List<Movie> listPerReleaseDate(int limit){
        return repository.listPerReleaseDate(limit);
    }
    
    public List<Movie> listPerImdbRating(int limit){
        return repository.listPerImdRating(limit);
    }
    
    
    public List<Movie> listPerSellPrice(int limit){
        return repository.listPerSellPrice(limit);
    }
    
    public List<Movie> listPerDuration(int limit){
        return repository.listPerDuration(limit);
    }
    

}
