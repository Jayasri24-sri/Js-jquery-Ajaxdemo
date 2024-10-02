package com.example.ajax.controller;
import com.example.ajax.model.Movie;
import com.example.ajax.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieController
{
    @Autowired
    private MovieService movieService;
    @PostMapping
    public void submitRating(@RequestBody Movie movie)
    {
        movieService.submitRating(movie);
    }

    @GetMapping("/average")
    public double getAverageRating()
    {
        return movieService.getAverageRating();
    }

    @GetMapping
    public List<Movie> getAllMovies()
    {
        return movieService.findAllMovies();
    }
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie updatedMovie)
    {
        return movieService.updateMovie(id, updatedMovie);
    }
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id)
    {
        movieService.deleteMovie(id);
    }
}
