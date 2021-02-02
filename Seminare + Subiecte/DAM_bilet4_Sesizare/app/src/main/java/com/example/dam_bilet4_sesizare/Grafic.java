package com.example.dam_bilet4_sesizare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class Grafic extends View {

    Context context;
    float[] valoriTipuri;
    String[] labels;
    public Grafic(Context context, float[] valoriTipuri, String[] labels) {
        super(context);
        this.context = context;
        this.valoriTipuri = valoriTipuri;
        this.labels = labels;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[] colors = {Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW, Color.RED, Color.BLACK};
        RectF rectangle = new RectF(10, 10, 500,500);

        Paint paint = new Paint();

        float total = 0;
        float[] pieValues = new float[valoriTipuri.length];
        for(int i = 0; i < valoriTipuri.length; i++){
            total += valoriTipuri[i];
        }

        for(int i = 0; i < valoriTipuri.length; i++){
            pieValues[i] = 360 * (valoriTipuri[i]/total);
        }

        int tmp = 0;
        for(int i = 0; i < valoriTipuri.length; i++){
            paint.setColor(colors[i]);
            paint.setTextSize(30);
            String text=labels[i];
            int x=600;
            int y=50+(i*50);
            canvas.drawText(text,x,y,paint);
            if(i == 0){
                canvas.drawArc(rectangle,0,valoriTipuri[i], true,paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Titlu", 10,10,paint);
            }else{
                tmp += (int)valoriTipuri[i - 1];
                canvas.drawArc(rectangle,tmp,valoriTipuri[i], true,paint);
            }
        }

    }
}
