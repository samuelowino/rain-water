package com.owino.customviews.donut;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.owino.customviews.R;

@SuppressLint("DrawAllocation")
public class Donut extends View {

    private int icingColor = Color.rgb(93, 64, 55);
    private int donutColor = Color.rgb(181, 61, 0);

    public Donut(Context context) {
        super(context);
    }

    public Donut(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Donut,
                0, 0
        );

        try {
            icingColor = attributes.getColor(R.styleable.Donut_icingColor, icingColor);
            donutColor = attributes.getColor(R.styleable.Donut_donutColor, donutColor);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } finally {
            attributes.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint donutDraw = new Paint();

        donutDraw.setColor(donutColor);

        Rect bounds = canvas.getClipBounds();

        //1. Draw base circle
        canvas.drawCircle(
                bounds.exactCenterX(),
                bounds.exactCenterY(),
                bounds.width() / 2f,
                donutDraw
        );

        canvas.save();

        //2. Add some chocolate with PathEffect

        Paint chocolatePaint = new Paint();
        chocolatePaint.setColor(icingColor);

        PathEffect pathEffect = new ComposePathEffect(
                new DiscretePathEffect(40f, 25f),
                new CornerPathEffect(40f)
        );

        chocolatePaint.setPathEffect(pathEffect);

        canvas.drawCircle(
                bounds.exactCenterX(),
                bounds.exactCenterY(),
                bounds.width() / 2.2f,
                chocolatePaint
        );

        canvas.restore();

        //3. Define donut hole path

        canvas.save();

        Paint donutHolePaint = new Paint();
        donutHolePaint.setColor(Color.WHITE);

        Path donutHolePath = new Path();

        donutHolePath.addCircle(
                bounds.exactCenterX(),
                bounds.exactCenterY(),
                bounds.width() / 6f,
                Path.Direction.CW
        );

        canvas.drawPath(donutHolePath, donutHolePaint);

        canvas.restore();
    }
}
