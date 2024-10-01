package com.example.ajax.controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController
{
    private final List<Integer> ratings = new ArrayList<>();
    @PostMapping
    public void submitRating(@RequestBody int rating)
    {
        ratings.add(rating);
    }
    @GetMapping("/average")
    public double getAverageRating()
    {
        if (ratings.isEmpty())
        {
            return 0.0; //returning 0 if there is no ratings
        }
        double total = ratings.stream().mapToInt(Integer::intValue).sum();
        return total / ratings.size(); //it will calculate average rating
    }
}
