package com.owino.imagesandgraphics;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    ImageView playToggleImageView;
    TransitionDrawable playPauseTransition;
    TransitionDrawable pausePlayTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playToggleImageView = findViewById(R.id.play_toggle_image_view);
        playPauseTransition = (TransitionDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.play_pause_transition, null);

        playToggleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPauseTransition.startTransition(1000);
            }
        });
    }
}