package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView, textView2, textView3;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        double weight = intent.getDoubleExtra("weight", 0);
        double height = intent.getDoubleExtra("height", 0);
        double bmi = intent.getDoubleExtra("bmi", 0);
        String status = intent.getStringExtra("status");

        textView.setText("Weight: " + weight + " kg");
        textView2.setText("Height: " + height + " cm"); // Display height in cm
        textView3.setText("BMI: " + String.format("%.2f", bmi) + " (" + status + ")");

        // Set back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
