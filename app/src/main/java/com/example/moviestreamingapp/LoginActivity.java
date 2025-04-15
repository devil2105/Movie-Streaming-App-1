package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText, passwordEditText;
    private MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Simple validation
                if (email.isEmpty()) {
                    emailEditText.setError("Email is required");
                    return;
                }

                if (password.isEmpty()) {
                    passwordEditText.setError("Password is required");
                    return;
                }

                // In a real app, you would validate the email and password against a server or local database.
                // For this example, we'll just assume the login is successful.

                // If validation passes, navigate to profile screen
                navigateToProfile(email);
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToProfile(String email) {
        try {
            Intent intent = new Intent(LoginActivity.this, FillProfileActivity.class);
            intent.putExtra("email", email); // Pass the email
            startActivity(intent);
            finish(); // Close login activity
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            Toast.makeText(LoginActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show(); // Show error
        }
    }
}
