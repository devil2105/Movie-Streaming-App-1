package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText, passwordEditText;
    private MaterialButton loginButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        mAuth = FirebaseAuth.getInstance();


        // Set click listener for login button
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty()) {
                emailEditText.setError("Email is required");
                return;
            }

            if (password.isEmpty()) {
                passwordEditText.setError("Password is required");
                return;
            }

            // First try sign-in
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            navigateToProfile(email);
                        } else {
                            // If login fails, try sign-up
                            mAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(signUpTask -> {
                                        if (signUpTask.isSuccessful()) {
                                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                                            if (firebaseUser != null) {
                                                String userId = firebaseUser.getUid();
                                                DatabaseReference reference = FirebaseDatabase.getInstance()
                                                        .getReference("users");
                                                String fullName = "Default Name";
                                                User user = new User(fullName, email);

                                                reference.child(userId).setValue(user).addOnCompleteListener(dbTask -> {
                                                    if (dbTask.isSuccessful()) {
                                                        Toast.makeText(LoginActivity.this, "Account created & data saved", Toast.LENGTH_SHORT).show();
                                                        navigateToProfile(email);
                                                    } else {
                                                        Toast.makeText(LoginActivity.this, "User created but failed to save data", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Login/Sign-up failed: " + signUpTask.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    });
                        }
                    });
        });

    }

            private void navigateToProfile(String email) {
                try {
                    Intent intent = new Intent(LoginActivity.this, FillProfileActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }