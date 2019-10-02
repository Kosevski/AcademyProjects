package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.movieapp.MovieRepository.getAllMovies;


public class MoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View View = inflater.inflate(R.layout.fragment_movie, container, false);
        final RecyclerView rvMovies = View.findViewById(R.id.rv_movies);
        final LinearLayoutManager llManager = new LinearLayoutManager(this.getContext());
        rvMovies.setLayoutManager(llManager);

        String genre = "";
        if (getArguments() != null) {
            genre = getArguments().getString("genre");
        }
        final List<Movie> movies = new ArrayList<>();
        List<Movie> allMovies = getAllMovies();
        for (int i = 0; i < allMovies.size(); i++) {
            Movie movie = allMovies.get(i);
            if (movie.getGenre().equals(genre)) {
                movies.add(movie);
            }
        }

        final MovieAdapter movieAdapter = new MovieAdapter(getContext(), movies);
        rvMovies.setAdapter(movieAdapter);

        return View;
    }
}




