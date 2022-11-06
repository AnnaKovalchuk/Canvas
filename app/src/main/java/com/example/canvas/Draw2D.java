package com.example.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;
    private Bitmap mBitmap2;

    public Draw2D(Context context){
        super(context);

        //Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.cat);
        mBitmap2 = BitmapFactory.decodeResource(res, R.drawable.butterfly);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int heiht = canvas.getHeight();

        //Стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        //Закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        //Рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(width - 150, 150, 150, mPaint);

        //Рисуем зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, canvas.getHeight() - 150, width, heiht, mPaint);

        //Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(52);
        canvas.drawText("Лужайка только для котиков! Бабочкам запрещено!", 30, heiht - 32, mPaint);

        //Текст под углом
        int x = width - 170;
        int y = 190;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(34);
        String str2rotate = "Лучик солнца!";

        canvas.save();

        //Создаем ограничивающий прямоугольник для наклонного текста
        //поворачиваем холст по центр текста
        canvas.rotate(-45, x + mRect.exactCenterX() + 125, y + mRect.exactCenterY() + 450);

        //Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

        //Восстанавливаем холст
        canvas.restore();

        //Выводим изображение
        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth() - 500, heiht - mBitmap.getHeight() - 60, mPaint);
        canvas.drawBitmap(mBitmap2, width - mBitmap.getWidth() - 1300, heiht - mBitmap.getHeight() - 100, mPaint);
    }

}
