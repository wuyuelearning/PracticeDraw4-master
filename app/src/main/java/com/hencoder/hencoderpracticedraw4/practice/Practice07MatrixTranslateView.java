package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice07MatrixTranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice07MatrixTranslateView(Context context) {
        super(context);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();

        Matrix matrix3 = new Matrix();
        Matrix matrix4 = new Matrix();

        float[] pointSrc = {point1.x, point1.y,
                point1.x + bitmap.getWidth(), point1.y,
                point1.x, point1.y + bitmap.getHeight(),
                point1.x + bitmap.getWidth(), point1.y + bitmap.getHeight()};

        float[] pointDst = {point1.x + 50, point1.y,
                point1.x + bitmap.getWidth() + 50, point1.y,
                point1.x + 50, point1.y + bitmap.getHeight(),
                point1.x + bitmap.getWidth() + 50, point1.y + bitmap.getHeight()};


        float[] pointSrc2 = {point2.x, point2.y,
                point2.x + bitmap.getWidth(), point2.y,
                point2.x, point2.y + bitmap.getHeight(),
                point2.x + bitmap.getWidth(), point2.y + bitmap.getHeight()};

        float[] pointDst2 = {point2.x + 50, point2.y + 50,
                point2.x + bitmap.getWidth() + 50, point2.y + 50,
                point2.x + 50, point2.y + bitmap.getHeight() + 50,
                point2.x + bitmap.getWidth() + 50, point2.y + bitmap.getHeight() + 50};

        matrix1.reset();
        matrix1.setPolyToPoly(pointSrc, 0, pointDst, 0, 4);

        matrix2.reset();
        matrix2.setPolyToPoly(pointSrc2, 0, pointDst2, 0, 4);


        canvas.save();
        canvas.concat(matrix1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.concat(matrix1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        canvas.save();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();


        canvas.save();
        matrix1.reset();
        matrix1.postTranslate(100,100);
        canvas.concat(matrix1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        matrix1.reset();
        matrix1.postTranslate(-100,-100);
        canvas.concat(matrix1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
