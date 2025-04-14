package com.example.moviestreamingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private RecyclerView topMoviesRecyclerView, newReleasesRecyclerView;
    private ImageView featuredMovieImage;
    private Button playButton, myListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        topMoviesRecyclerView = findViewById(R.id.topMoviesRecyclerView);
        newReleasesRecyclerView = findViewById(R.id.newReleasesRecyclerView);
        featuredMovieImage = findViewById(R.id.featuredMovieImage);
        playButton = findViewById(R.id.playButton);
        myListButton = findViewById(R.id.myListButton);

        // Set up navigation
        setupBottomNavigation();

        // Set up Featured Movie
        setupFeaturedMovie();

        // Set up RecyclerViews
        setupTopMoviesRecyclerView();
        setupNewReleasesRecyclerView();

        // Set up button click listeners
        setupButtonListeners();
    }

    private void setupFeaturedMovie() {
        String featuredMovieUrl = "https://image.tmdb.org/t/p/w500/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg";
        Glide.with(this)
                .load(featuredMovieUrl)
                .placeholder(R.drawable.movie_error)
                .error(R.drawable.movie_error)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(featuredMovieImage);
    }

    private void setupButtonListeners() {
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
            intent.putExtra("youtube_id", "aWzlQ2N6qqg"); // Dr. Strange 2 trailer
            startActivity(intent);
        });

        myListButton.setOnClickListener(v -> {
            Toast.makeText(this, "Added to My List", Toast.LENGTH_SHORT).show();
        });
    }

    private void setupTopMoviesRecyclerView() {
        List<Movie> topMovies = new ArrayList<>();
        topMovies.add(new Movie("1", "Avengers: Endgame",
                "https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                1, "TcMBFSGVi1c"));
        topMovies.add(new Movie("2", "Black Panther",
                "https://image.tmdb.org/t/p/w500/uxzzxijgPIY7slzFvMotPv8wjKA.jpg",
                2, "xjDjIWPwcPU"));
        topMovies.add(new Movie("3", "Spider-Man: No Way Home",
                "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                3, "JfVOs4VSpmA"));
        topMovies.add(new Movie("4", "Avatar: The Way of Water",
                "https://image.tmdb.org/t/p/w500/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                4, "d9MyW72ELq0"));
        topMovies.add(new Movie("5", "Top Gun: Maverick",
                "https://image.tmdb.org/t/p/w500/62HCnUTziyWcpDaBO2i1DX17ljH.jpg",
                5, "qSqVVswa4vg"));
        topMovies.add(new Movie("6", "The Batman",
                "https://image.tmdb.org/t/p/w500/74xTEgt7R36Fpooo50r9T25onhq.jpg",
                6, "mqqft2x_Aa4"));
        topMovies.add(new Movie("7", "Jurassic World Dominion",
                "https://image.tmdb.org/t/p/w500/kAVRgw7GgK1CfYEJq8ME6EvRIgU.jpg",
                7, "fb5ELWi-ekk"));
        topMovies.add(new Movie("8", "Doctor Strange in the Multiverse of Madness",
                "https://image.tmdb.org/t/p/w500/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
                8, "aWzlQ2N6qqg"));
        topMovies.add(new Movie("9", "Minions: The Rise of Gru",
                "https://image.tmdb.org/t/p/w500/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg",
                9, "6DxjJzmzsX8"));
        topMovies.add(new Movie("10", "Thor: Love and Thunder",
                "https://image.tmdb.org/t/p/w500/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
                10, "Go8nTmfrQd8"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);
        topMoviesRecyclerView.setLayoutManager(layoutManager);

        TopMoviesAdapter adapter = new TopMoviesAdapter(this, topMovies);
        topMoviesRecyclerView.setAdapter(adapter);
    }

    private void setupNewReleasesRecyclerView() {
        List<Movie> newReleases = new ArrayList<>();
        newReleases.add(new Movie("11", "Dune: Part Two",
                "https://image.tmdb.org/t/p/w500/8b8R8l88Qje9dn9OE8PY05Nxl1X.jpg",
                0, "n9xhJrPXop4"));
        newReleases.add(new Movie("12", "The Marvels",
                "https://image.tmdb.org/t/p/w500/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                0, "mS2hOE6cGvE"));
        newReleases.add(new Movie("13", "Oppenheimer",
                "https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
                0, "uYPbbksJxIg"));
        newReleases.add(new Movie("14", "Barbie",
                "https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
                0, "pBk4NYhWNMM"));
        newReleases.add(new Movie("15", "Mission: Impossible - Dead Reckoning",
                "https://image.tmdb.org/t/p/w500/NNxYkU70HPurnNCSiCjYAmacwm.jpg",
                0, "avz06pdqSMI"));
        newReleases.add(new Movie("16", "Guardians of the Galaxy Vol. 3",
                "https://image.tmdb.org/t/p/w500/r2J02Z2OpNTctfOSN1Ydgii51I3.jpg",
                0, "u3V5KDHRQvk"));
        newReleases.add(new Movie("17", "Fast X",
                "https://image.tmdb.org/t/p/w500/fiVW06jE7z9YnO4trhaMEdclSiC.jpg",
                0, "eoOaKN4qCKw"));
        newReleases.add(new Movie("18", "The Little Mermaid",
                "https://image.tmdb.org/t/p/w500/ym1dxyOk4jFcSl4Q2zmRrA5BEEN.jpg",
                0, "kpGo2_d3oYE"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);
        newReleasesRecyclerView.setLayoutManager(layoutManager);

        NewReleasesAdapter adapter = new NewReleasesAdapter(this, newReleases);
        newReleasesRecyclerView.setAdapter(adapter);
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.nav_home) {
                            return true;
                        } else if (itemId == R.id.nav_search) {
                            startActivity(new Intent(MainActivity.this, SearchActivity.class));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            return true;
                        } else if (itemId == R.id.nav_library) {
                            Toast.makeText(MainActivity.this, "Library clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.nav_downloads) {
                            Toast.makeText(MainActivity.this, "Downloads clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.nav_profile) {
                            Toast.makeText(MainActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    public static class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.MovieViewHolder> {
        private List<Movie> movies;
        private Context context;

        public TopMoviesAdapter(Context context, List<Movie> movies) {
            this.context = context;
            this.movies = movies;
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

            holder.topBadge.setText(String.valueOf(movie.getPosition()));

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("youtube_id", movie.getYoutubeId());
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() { return movies.size(); }

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

    public static class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.MovieViewHolder> {
        private List<Movie> movies;
        private Context context;

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
                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("youtube_id", movie.getYoutubeId());
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() { return movies.size(); }

        public static class MovieViewHolder extends RecyclerView.ViewHolder {
            ImageView moviePoster;

            public MovieViewHolder(@NonNull View itemView) {
                super(itemView);
                moviePoster = itemView.findViewById(R.id.moviePoster);
            }
        }
    }
}