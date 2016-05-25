package com.example.sussan.training2.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 * Created by Sussan on 25.05.2016.
 */
public class SchematicModeLearning {

    private int widthOfDiagramm;
    private int heightOfDiagramm;
    private Bitmap diagramm;

    ArrayList<textToLearn> allText;


    private void initBitmap()
    {
        Log.e("DiagrammView", "initBitmap");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        diagramm = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Lernapp/quadrate.png", options);
        if (diagramm == null)
        {
            Log.e("DiagrammView", "mist bitmap null");
        }
        else
        {
            Log.e("DiagrammView", "oder nicht null");

        }

    }

    public LinearLayout initTextToLearn(LinearLayout container)
    {
        TextView tv = new TextView(container.getContext());
        tv.setText("textView neu");

        LinearLayout.LayoutParams vp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tv.setLayoutParams(vp);

        container.addView(tv);

        return container;

    }

    public LinearLayout createLayoutOfDiagramm(LinearLayout container, int widthOfDisplay, int heightOfDisplay, int Margins)
        {
            initBitmap();


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
