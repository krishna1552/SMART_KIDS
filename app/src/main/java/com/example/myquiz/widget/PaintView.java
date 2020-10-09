package com.example.myquiz.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myquiz.common.Common;
import com.example.myquiz.utils.Fill;

public class PaintView extends View {

    Bitmap bitmap;

    public PaintView(Context context) {
        super ( context );
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged ( w, h, oldw, oldh );

        if(bitmap == null) {
            Bitmap srcBitmap = BitmapFactory.decodeResource ( getResources (), Common.PICTURE_SELECTED );
            bitmap = Bitmap.createScaledBitmap ( srcBitmap, w, h, false );

            for(int i=0; i<bitmap.getWidth (); i++){
                for(int j=0; j<bitmap.getHeight (); j++){
                    int alpha = 255-brightness(bitmap.getPixel ( i,j ));
                    if(alpha < 200){
                        bitmap.setPixel ( i,j,Color.WHITE );
                    }else {
                        bitmap.setPixel ( i,j, Color.BLACK );
                    }
                }
            }
        }
    }

    private int brightness(int color) {
        return (color >> 16) & 0xff;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw ( canvas );
        canvas.drawBitmap ( bitmap,0,0,null );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        paint((int)event.getX (),(int)event.getY ());

        return true;
    }

    private void paint(int x, int y) {

        int targetColor = bitmap.getPixel ( x,y );
        if(targetColor != Color.BLACK){
        Fill.Fill (bitmap,new Point (x,y), targetColor, Common.COLOR_SELECTED );
        invalidate ();
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
