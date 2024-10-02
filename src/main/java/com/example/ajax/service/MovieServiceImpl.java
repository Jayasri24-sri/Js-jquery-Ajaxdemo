package com.example.ajax.service;
import com.example.ajax.model.Movie;
import com.example.ajax.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl extends MovieService
{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public void submitRating(Movie movie)
    {
        movieRepository.save(movie);
    }
    @Override
    public double getAverageRating()
    {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty())
        {
            return 0.0;
        }
        double total = movies.stream().mapToDouble(Movie::getRating).sum();
        return total / movies.size();
    }
    @Override
    public List<Movie> findAllMovies()
    {
        return movieRepository.findAll();
    }
    @Override
    public void deleteMovie(String id)
    {
        movieRepository.deleteById(id);
    }
    @Override
    public Movie updateMovie(String id, Movie updatedMovie)
    {
        Optional<Movie> movieOpt = movieRepository.findById(id);
        if (movieOpt.isPresent())
        {
            Movie existingMovie = movieOpt.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setRating(updatedMovie.getRating());
            return movieRepository.save(existingMovie);
        }
        return null;
    }
}
