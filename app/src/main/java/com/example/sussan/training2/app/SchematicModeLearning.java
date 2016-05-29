package com.example.sussan.training2.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 * Created by Sussan on 25.05.2016.
 */
public class SchematicModeLearning extends RelativeLayout {

    private int factorDiagrammImage;

    private Bitmap diagramm;

    ArrayList<textToLearn> allText;

    public SchematicModeLearning(Context context) {
        super(context);
    }

    public void dummy()
    {
        initBitmap();

        ImageView diagrammView = new ImageView(this.getContext());

        RelativeLayout.LayoutParams vp2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        vp2.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        diagrammView.setLayoutParams(vp2);

        diagrammView.setImageBitmap(diagramm);

        this.addView(diagrammView);
    }

    private void initBitmap()
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        diagramm = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Lernapp/quadrate.png", options);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("onStart",  "this.getHeight()" +  this.getHeight());
        Log.e("onStart",  " this.getHeight()" +  this.getMeasuredHeight());
        Log.e("onStart",  " this.getHeight()" +  this.getX());

        factorDiagrammImage = calculateFactorImageAndDisplay(diagramm.getWidth(), diagramm.getHeight(), this.getWidth(), this.getHeight());

    }


    public LinearLayout createLayoutOfDiagramm(Context context, int widthOfDisplay, int heightOfDisplay, int Margins)
        {
            initBitmap();

            LinearLayout container = new LinearLayout(context);
        Log.e("DiagrammView", "createLayoutOfDiagramm");
        ImageView diagrammView = new ImageView(container.getContext()); //(ImageView)findViewById(R.id.DiagrammImage);
        Log.e("DiagrammView", "diagrammView erstellt");

        LinearLayout.LayoutParams vp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        diagrammView.setLayoutParams(vp);

        Log.e("DiagrammView", "params gesetzt");

        if(diagrammView == null)
        {
            Log.e("DiagrammView", "diagrammView is null");
        }
        diagrammView.setImageBitmap(diagramm);
        Log.e("DiagrammView", "diagramm gesetzt");

        container.addView(diagrammView);
        Log.e("DiagrammView", "diagrammView geaddet");

        //       int widthFactor = Math.round(widthOfDisplay / diagramm.getHeight());
        //       int heightFactor = Math.round(heightOfDisplay / diagramm.getWidth());

        int widthFactor = 20;
        int heightFactor = 20;

        textToLearn t = new textToLearn(100,100,"Hallo");
        Log.e("DiagrammView", "create textToLearn");
        allText = new ArrayList<textToLearn>();
        allText.add(t);

        Log.e("DiagrammView", "t geaddet");

        for (textToLearn text : allText)
        {
            Log.e("DiagrammView", "in for-schleife");
            Button text_bnt = new Button(container.getContext());
            text_bnt.setText(text.text);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = text.x*widthFactor;
            params.rightMargin = text.y*heightFactor;
            text_bnt.setLayoutParams(params);
            Log.e("DiagrammView", "fast ende for-schleife");
            container.addView(text_bnt);
            // a.addContentView(text_bnt, params);

            Log.e("DiagrammView", " ende for-schleife");

        }

            return container;

    }

    /* calculate the factor between Image and Display */
    private int calculateFactorImageAndDisplay(int imageX, int imageY, int displayX, int displayY)
    {
        int factor;

        float displayApectRatio = (displayX/displayY);
        float imageApectRatio = (imageX/imageY);

        if(displayApectRatio >= imageApectRatio)
        {
            factor = Math.round(1 / displayY);
        }
        else
        {
            factor = Math.round(1 / displayX);
        }

        return factor;
    }


    class textToLearn
    {
        int x;
        int y;
        String text;

        textToLearn(int px, int py, String ptext)
        {
            x = px;
            y = py;
            text = ptext;
        }
    }

}
