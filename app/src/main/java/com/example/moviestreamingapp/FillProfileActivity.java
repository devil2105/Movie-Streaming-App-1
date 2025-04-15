package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FillProfileActivity extends AppCompatActivity {

    private ImageView backButton;
    private ImageView profileImageView;
    private ImageView editProfileImageIcon;
    private EditText fullNameEditText;
    private EditText nicknameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private Button skipButton;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize UI elements
        backButton = findViewById(R.id.backButton);
        profileImageView = findViewById(R.id.profileImageView);
        editProfileImageIcon = findViewById(R.id.editProfileImageIcon);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        nicknameEditText = findViewById(R.id.nicknameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        skipButton = findViewById(R.id.skipButton);
        continueButton = findViewById(R.id.continueButton);

        // Pre-fill email from login
        String email = getIntent().getStringExtra("email");
        if (email != null) {
            emailEditText.setText(email);
        }

        // Set up listeners
        backButton.setOnClickListener(v -> finish());

        editProfileImageIcon.setOnClickListener(v -> {
            Toast.makeText(FillProfileActivity.this, "Edit profile picture", Toast.LENGTH_SHORT).show();
            // TODO: Implement image selection logic here
        });

        skipButton.setOnClickListener(v -> {
            navigateToInterests();
            Toast.makeText(FillProfileActivity.this, "Skipped profile setup", Toast.LENGTH_SHORT).show();
        });

        continueButton.setOnClickListener(v -> validateAndContinue());
    }

    private void validateAndContinue() {
        String fullName = fullNameEditText.getText().toString().trim();
        String nickname = nicknameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();

        if (fullName.isEmpty()) {
            fullNameEditText.setError("Full Name is required");
            return;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Valid email is required");
            return;
        }

        // All validations passed
        navigateToInterests();
        Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
    }

    private void navigateToInterests() {
        Intent intent = new Intent(this, InterestsActivity.class);
        startActivity(intent);
        finish(); // Close profile activity
    }
}
