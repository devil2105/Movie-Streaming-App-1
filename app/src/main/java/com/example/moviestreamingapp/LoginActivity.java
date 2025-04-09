package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize buttons
        MaterialButton btnPassword = findViewById(R.id.btn_password);
        MaterialButton btnFacebook = findViewById(R.id.btn_facebook);
        MaterialButton btnGoogle = findViewById(R.id.btn_google);
        MaterialButton btnApple = findViewById(R.id.btn_apple);

        // Set click listeners
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInterests();
                Toast.makeText(LoginActivity.this, "Password Login clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInterests();
                Toast.makeText(LoginActivity.this, "Facebook Login clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInterests();
                Toast.makeText(LoginActivity.this, "Google Login clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInterests();
                Toast.makeText(LoginActivity.this, "Apple Login clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToInterests() {
        Intent intent = new Intent(LoginActivity.this, InterestsActivity.class);
        startActivity(intent);
        // Optional: finish() if you want to close the login activity
        // finish();
    }
}