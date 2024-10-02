package com.example.ajax.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "movies")
public class Movie
{
    @Id
    private String id;
    private String title;
    private double rating;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public double getRating()
    {
        return rating;
    }
    public void setRating(double rating)
    {
        this.rating = rating;
    }
}
