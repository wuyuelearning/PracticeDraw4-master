package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float centerx1=point1.x+bitmap.getWidth()/2;
        float centery1=point1.y+bitmap.getHeight()/2;

        float centerx2=point2.x+bitmap.getWidth()/2;
        float centery2=point2.x+bitmap.getWidth()/2;

        Camera camera =new Camera();

        Matrix matrix =new Matrix();


        canvas.save();
        camera.save();
        camera.rotateX(30);
        canvas.translate(centerx1,centery1);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerx1,-centery1);
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        camera.save();
        matrix.reset();
        camera.rotateX(30);
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerx1,-centery1);                //  反着画
        matrix.postTranslate(centerx1,centery1);
        canvas.concat(matrix);
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x-100, point1.y, paint);
        canvas.restore();


        canvas.save();
        camera.save();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerx2,-centerx2);
        matrix.postTranslate(centerx2,centerx2);
        canvas.concat(matrix);
        matrix.reset();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();


    }
}
