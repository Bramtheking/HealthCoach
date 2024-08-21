package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class ClockView extends View {

    private Paint paint;
    private int width, height;
    private float radius;
    private Handler handler;

    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        handler = new Handler();

        // Update the clock every second
        handler.post(new Runnable() {
            @Override
            public void run() {
                invalidate();
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        radius = Math.min(width, height) / 2 * 0.9f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get current time
        Calendar calendar = Calendar.getInstance();
        float hours = calendar.get(Calendar.HOUR_OF_DAY);
        float minutes = calendar.get(Calendar.MINUTE);
        float seconds = calendar.get(Calendar.SECOND);

        // Draw the clock circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(width / 2, height / 2, radius, paint);

        // Draw the clock hands
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(8);

        // Draw hours hand
        float hourAngle = (hours % 12) * 30 + minutes * 0.5f;
        drawHand(canvas, hourAngle, radius * 0.5f);

        // Draw minutes hand
        float minuteAngle = minutes * 6;
        drawHand(canvas, minuteAngle, radius * 0.7f);

        // Draw seconds hand
        paint.setColor(Color.RED);
        float secondAngle = seconds * 6;
        drawHand(canvas, secondAngle, radius * 0.9f);
    }

    private void drawHand(Canvas canvas, float angle, float handRadius) {
        double radian = Math.toRadians(angle - 90);
        float endX = (float) (width / 2 + handRadius * Math.cos(radian));
        float endY = (float) (height / 2 + handRadius * Math.sin(radian));
        canvas.drawLine(width / 2, height / 2, endX, endY, paint);
    }
}
