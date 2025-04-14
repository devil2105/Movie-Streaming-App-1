package com.example.moviestreamingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast; // Add this import statement

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.MovieViewHolder> {
    private final Context context;
    private final List<Movie> movies;

    public NewReleasesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_new_release, parent, false);
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

        holder.itemView.setOnClickListener(v -> {
            if (movie.getYoutubeId() != null && !movie.getYoutubeId().isEmpty()) {
                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("youtube_id", movie.getYoutubeId());
                context.startActivity(intent);
            } else {
                Toast.makeText(context,
                        "Trailer not available for " + movie.getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.moviePoster);
        }
    }
}