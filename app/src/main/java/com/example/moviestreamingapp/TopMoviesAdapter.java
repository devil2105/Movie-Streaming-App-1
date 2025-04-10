package com.example.moviestreamingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.MovieViewHolder> {
    private final Context context;
    private final List<Movie> movies; // Add this line to declare the movies list

    // Add constructor to initialize both context and movies
    public TopMoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Keep your Movie class definition as is
    class Movie {
        private String id;
        private String title;
        private String posterUrl;
        private int position;

        public Movie(String id, String title, String posterUrl, int position) {
            this.id = id;
            this.title = title;
            this.posterUrl = posterUrl;
            this.position = position;
        }

        public String getId() { return id; }
        public String getTitle() { return title; }
        public String getPosterUrl() { return posterUrl; }
        public int getPosition() { return position; }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        Glide.with(context)
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.movie_error)
                .error(R.drawable.movie_error)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.moviePoster);

        holder.topBadge.setText(String.valueOf(position + 1));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView topBadge;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.moviePoster);
            topBadge = itemView.findViewById(R.id.topBadge);
        }
    }
}