package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up navigation
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.nav_home) {
                            // Already on home, just refresh if needed
                            return true;
                        } else if (itemId == R.id.nav_search) {
                            // Launch SearchActivity
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

        // Set home as default selected item
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reset to home selection when returning to MainActivity
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }
}