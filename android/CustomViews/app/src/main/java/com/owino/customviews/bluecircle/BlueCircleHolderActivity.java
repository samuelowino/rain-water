package com.owino.customviews.bluecircle;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.owino.customviews.MainActivity;
import com.owino.customviews.R;

public class BlueCircleHolderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_circle);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent(BlueCircleHolderActivity.this, MainActivity.class));
        finish();
    }
}
