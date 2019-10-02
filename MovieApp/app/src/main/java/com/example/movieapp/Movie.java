package com.example.movieapp;


public class Movie {
    private String name;
    private String director;
    private String url;
    private String genre;
    private String description;

    Movie(String name, String director, String url, String genre, String description) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.url = url;
        this.description = description;
    }

    String getName(){
        return name;
    }

    String getDirector(){
        return director;
    }

    String getUrl(){
        return url;
    }

     String getGenre(){
        return genre;
  }
    String getDescription() {
        return description;
    }
}