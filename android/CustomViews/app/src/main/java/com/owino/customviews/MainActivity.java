package com.owino.customviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.owino.customviews.bluecircle.BlueCircleHolderActivity;
import com.owino.customviews.donut.DonutHolderActivity;

public class MainActivity extends AppCompatActivity {
    Button blueCircle;
    Button donut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blueCircle = findViewById(R.id.blue_circle_button);
        donut = findViewById(R.id.donut_button);
        blueCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this, BlueCircleHolderActivity.class));
                finish();
            }
        });
        donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this, DonutHolderActivity.class));
                finish();
            }
        });
    }
}