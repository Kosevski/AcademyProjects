package com.example.movieapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder> implements View.OnClickListener {
    public List<Movie> movies;
    Context mContext;


    public MovieAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        mContext = context;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull
                                                       ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(R.layout.item_movie, parent, false);

        MoviesViewHolder viewHolder = new MoviesViewHolder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MoviesViewHolder holder, final int position) {
        final Movie movie = movies.get(position);
        holder.tvName.setText(movie.getName());
        holder.descriptionM.setText(movie.getDescription());
        holder.tvDirector.setText(movie.getDirector());
        String uri = movie.getUrl();
        Glide.with(holder.imgMovie.getContext()).load(uri).into(holder.imgMovie);


        holder.removeMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LayoutInflater mInflater = LayoutInflater.from(mContext);
                View v = mInflater.inflate(R.layout.item_movie, null, true);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

                alertDialog.setTitle("You are trying to delete a movie from the list:");
                alertDialog.setMessage("Are you sure you want to delete this movie from the RecycleView list?");
                alertDialog.setNegativeButton("No.", null);
                alertDialog.setPositiveButton("Yes, im sure.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        movies.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                    }
                });
                alertDialog.show();
            }
        });

        holder.imgMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ActivityDetails.class);
                intent.putExtra("name", movie.getName());
                intent.putExtra("director", movie.getDirector());
                intent.putExtra("description", movie.getDescription());
                intent.putExtra("img", movie.getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDirector;
        public ImageView imgMovie;
        public ImageView removeMovie;
        public TextView descriptionM;

        public MoviesViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDirector = itemView.findViewById(R.id.tv_director);
            imgMovie = itemView.findViewById(R.id.movieIMG);
            removeMovie = itemView.findViewById(R.id.remove_movie);
            descriptionM = itemView.findViewById(R.id.description);
        }
    }

}






