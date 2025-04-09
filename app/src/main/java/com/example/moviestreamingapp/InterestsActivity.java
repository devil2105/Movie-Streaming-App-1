package com.example.moviestreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class InterestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        ChipGroup chipGroup = findViewById(R.id.chipGroup);
        Button btnSkip = findViewById(R.id.btnSkip);
        Button btnContinue = findViewById(R.id.btnContinue);

        // Set up chip selection colors
        setupChipColors(chipGroup);

        // Skip button click handler
        btnSkip.setOnClickListener(v -> {
            startActivity(new Intent(InterestsActivity.this, MainActivity.class));
            finish(); // Close the interests screen
        });

        // Continue button click handler
        btnContinue.setOnClickListener(v -> {
            StringBuilder selectedInterests = getSelectedInterests(chipGroup);

            if (selectedInterests.length() == 0) {
                Toast.makeText(this, "Please select at least one interest", Toast.LENGTH_SHORT).show();
                return;
            }

            // You can store selected interests if needed before navigating
            startActivity(new Intent(InterestsActivity.this, MainActivity.class));
            finish(); // Close the interests screen
        });
    }

    private void setupChipColors(ChipGroup chipGroup) {
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);

            // Set initial colors
            chip.setChipBackgroundColorResource(R.color.chip_unselected_bg);
            chip.setChipStrokeColorResource(R.color.chip_unselected_stroke);

            // Add checked change listener
            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    chip.setChipBackgroundColorResource(R.color.chip_selected_bg);
                    chip.setChipStrokeColorResource(R.color.chip_selected_stroke);
                } else {
                    chip.setChipBackgroundColorResource(R.color.chip_unselected_bg);
                    chip.setChipStrokeColorResource(R.color.chip_unselected_stroke);
                }
            });
        }
    }

    private StringBuilder getSelectedInterests(ChipGroup chipGroup) {
        StringBuilder selectedInterests = new StringBuilder();
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            if (chip.isChecked()) {
                if (selectedInterests.length() > 0) {
                    selectedInterests.append(", ");
                }
                selectedInterests.append(chip.getText());
            }
        }
        return selectedInterests;
    }
}
