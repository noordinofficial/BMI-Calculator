package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextWeight, editTextTextHeight;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextWeight = findViewById(R.id.editTextTextWeight);
        editTextTextHeight = findViewById(R.id.editTextTextHeight);
        buttonCalculate = findViewById(R.id.button1);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextTextWeight.getText().toString();
        String heightStr = editTextTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            // Handle empty fields
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr); // Height assumed to be in cm

        double bmi = weight / ((height / 100) * (height / 100));

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >18.5 & bmi< 24.9) {
            status = "Healthy Weight";
        } else if (bmi>25 & bmi< 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("bmi", bmi);
        intent.putExtra("status", status);
        startActivity(intent);
    }
}
