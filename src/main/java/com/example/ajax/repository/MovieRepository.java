package com.example.ajax.repository;
import com.example.ajax.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MovieRepository extends MongoRepository<Movie, String>
{
}

