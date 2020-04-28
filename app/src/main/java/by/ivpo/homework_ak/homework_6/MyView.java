package by.ivpo.homework_ak.homework_6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    Paint p = new Paint();
    int pThick = 10;
    Canvas canvas;
    int persent = 0;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;

        drawMyView(0, 0, persent);

    }

    public void drawMyView(int x, int y, int persent) {
        drawCircle(x, y);
        drawShading(x, y, persent);
        drawBorder(x, y);
        drawtext(x, y, persent + "");
    }

    public void drawCircle(int x, int y) {
        p.setStrokeWidth(pThick);
        RectF rect1 = new RectF(x, y, getWidth(), getHeight());
        p.setColor(Color.GREEN);
        p.setAlpha(127);
        canvas.drawOval(rect1, p);
    }

    public void drawShading(int x, int y, int persent) {

        float persentF = 1 - persent / 100F;

        RectF rect2 = new RectF(x, y, getWidth(), getHeight() * persentF);
        p.setAlpha(255);
        p.setColor(Color.WHITE);
        canvas.drawRect(rect2, p);
    }

    public void drawBorder(int x, int y) {
        RectF rect3 = new RectF(x + pThick / 2, y + pThick / 2, x + getWidth() - pThick / 2, y + getHeight() - pThick / 2);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLUE);
        canvas.drawOval(rect3, p);
    }

    public void drawtext(int x, int y, String text) {
        p.setStrokeWidth(5);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize(getHeight() / 2);
        p.setColor(Color.BLUE);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, x + getWidth() / 2, y + getWidth() * 2 / 3, p);
    }

}
