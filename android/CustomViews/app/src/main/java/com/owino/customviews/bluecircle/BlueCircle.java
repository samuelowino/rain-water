package com.owino.customviews.bluecircle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

@SuppressLint("DrawAllocation")
public class BlueCircle extends View {
    public BlueCircle(Context context) {
        super(context);
    }

    public BlueCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);
        Rect bounds = canvas.getClipBounds();

        canvas.drawCircle(
                bounds.exactCenterX(),
                bounds.exactCenterY(),
                bounds.width() / 2f,
                circlePaint
        );
    }
}
