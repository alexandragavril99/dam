package com.example.seminar12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.Toast;

public class Grafica extends View {
    public Grafica(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);

        canvas.drawLine(0,0,200,200, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(200,200,500,500,paint);

        Paint instrument = new Paint();
        instrument.setStyle(Paint.Style.FILL);
        instrument.setColor(Color.rgb(255,255,0));
        canvas.drawCircle(350,650,150,instrument);

        instrument.setColor(Color.rgb((30*56)%256, (45*75)%256,(34*82)%256));
        canvas.drawArc(200,200,500,500,90,135,true,instrument);
        instrument.setColor(Color.BLUE);
        canvas.drawArc(200,200,500,500,225,60,true,instrument);

        Paint instrumentScriere = new Paint();
        instrumentScriere.setColor(Color.BLACK);
        instrumentScriere.setTextSize(50);
        instrumentScriere.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Text desenat cu succes!!!",200,850,instrumentScriere);

        Shader gradient = new LinearGradient(200, 855, 800, 1200,Color.BLUE, Color.YELLOW, Shader.TileMode.MIRROR);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);

        canvas.drawRect(200,850,800,1200,p);

        Paint paint1 = new Paint();
        paint1.setShader(gradient);
        canvas.drawCircle(400,1050,150,paint1);
        Toast.makeText(getContext(),"ACTIVITATE REGASITA",Toast.LENGTH_LONG).show();

    }
}
