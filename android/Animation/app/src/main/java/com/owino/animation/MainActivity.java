package com.owino.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView ball;
    Button kickUpActionButton;
    Button kickLeftActionButton;
    Button kickRightActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.ball);
        kickUpActionButton = findViewById(R.id.kick_up_action_button);
        kickRightActionButton = findViewById(R.id.kick_right_action_button);
        kickLeftActionButton = findViewById(R.id.kick_left_action_button);

        kickLeftActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ValueAnimator.ofInt(1,100);
                animator.setDuration(1000);
                animator.setInterpolator( new BounceInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int animatedValue = (int) valueAnimator.getAnimatedValue();
                        ball.setTranslationX(-animatedValue * 3);
                    }
                });
                animator.start();
            }
        });

        kickRightActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ValueAnimator.ofInt(1,100);
                animator.setDuration(1000);
                animator.setInterpolator( new BounceInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int animatedValue = (int) valueAnimator.getAnimatedValue();
                        ball.setTranslationX(animatedValue * 3);
                    }
                });
                animator.start();
            }
        });

        kickUpActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ValueAnimator.ofInt(1,100);
                animator.setDuration(3000);
                animator.setInterpolator( new BounceInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int animatedValue = (int) valueAnimator.getAnimatedValue();
                        ball.setTranslationY(-(animatedValue * 10));
                    }
                });
                animator.start();
            }
        });
    }
}