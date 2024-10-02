package com.example.ajax.service;
import com.example.ajax.model.Movie;
import java.util.List;
public abstract class MovieService
{
    public abstract void submitRating(Movie movie);
    public abstract double getAverageRating();
    public abstract List<Movie> findAllMovies();
    public abstract void deleteMovie(String id);
    public abstract Movie updateMovie(String id, Movie updatedMovie);
}
