package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search); // Your XML layout

        // Initialize Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.nav_home) {
                            // Navigate back to home
                            startActivity(new Intent(SearchActivity.this, MainActivity.class));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            return true;
                        } else if (itemId == R.id.nav_search) {
                            // Already on search screen
                            return true;
                        } else if (itemId == R.id.nav_library) {
                            Toast.makeText(SearchActivity.this, "Library clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.nav_downloads) {
                            Toast.makeText(SearchActivity.this, "Downloads clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.nav_profile) {
                            Toast.makeText(SearchActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        }

                        return false;
                    }
                });

        // Set search as selected
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Ensure the selected item stays on Search
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
    }
}
