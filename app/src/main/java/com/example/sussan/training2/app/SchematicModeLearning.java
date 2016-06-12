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
public class SchematicModeLearning extends RelativeLayout implements LearningUnit{

    private float factorDiagrammImage;
    private int movSchematicTextRight;
    private int movSchematicTextDown;

    private Bitmap diagramm;

    private String learningUnitTitel;
    private ArrayList<textToLearn> allText;
    private String schematicPath;

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
/************************* init information **********************************/
    public void setLetterings(int xposition, int yposition, String text )
    {
        textToLearn lettering = new textToLearn(xposition, yposition, text);

        if(allText == null)
        {
            allText = new ArrayList<textToLearn>();
        }

        allText.add(lettering);
    }

    public void setLetteringPath(String path)
    {
        schematicPath = path;
    }


/*****************************************************************************/
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("onStart",  "this.getHeight()" +  this.getHeight());
        Log.e("onStart",  " this.getWidth()" +  this.getWidth());


         calculateFactorImageAndDisplay(diagramm.getWidth(), diagramm.getHeight(), this.getWidth(), this.getHeight());

        textToLearn t = new textToLearn(0,100,"Hallo");
        Log.e("DiagrammView", "create textToLearn");
        allText = new ArrayList<textToLearn>();
        allText.add(t);

        for (textToLearn text : allText)
        {
            Log.e("DiagrammView", "in for-schleife");
            Button text_bnt = new Button(this.getContext());
            text_bnt.setText(text.text);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = Math.round((float)text.x*(float)diagramm.getWidth()*factorDiagrammImage) + movSchematicTextRight;
            params.topMargin = Math.round((float)text.y*(float)diagramm.getHeight()*factorDiagrammImage) + movSchematicTextDown;
            text_bnt.setLayoutParams(params);
            Log.e("SchematicModeLearning", " params.leftMargin " +  params.leftMargin);
            Log.e("SchematicModeLearning", " params.topMargin " +  params.topMargin);

            this.addView(text_bnt);
            // a.addContentView(text_bnt, params);

            Log.e("DiagrammView", " ende for-schleife");

        }

    }


/********************** supporting functions *********************************/

    private void initBitmap()
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        diagramm = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Lernapp/quadrate.png", options);
    }
    /* calculate the factor between Image and Display */
    private void calculateFactorImageAndDisplay(int imageX, int imageY, int displayX, int displayY)
    {
        float factor;

        float displayApectRatio = ((float)displayX/(float)displayY);
        float imageApectRatio = ((float)imageX/(float)imageY);

        if(displayApectRatio >= imageApectRatio)
        {
            factor = (1.0f / (float)displayY);

            movSchematicTextRight = Math.round((float)(displayX-imageX)*0.5f*factor*imageX);
            movSchematicTextDown = 0;
            Log.e("SchematicModeLearning", " movSchematicTextRight  "+ movSchematicTextRight);
        }
        else
        {
            Log.e("SchematicModeLearning", " 1 / displayX  "+ 1 / (float)displayX);
            factor =(1.0f / (float)displayX);

            movSchematicTextDown = Math.round((float)(displayY-imageY)*0.5f*factor*imageY);
            movSchematicTextRight = 0;
            Log.e("SchematicModeLearning", " (float)(displayY-imageY)*0.5f*factor  "+ (float)(displayY-imageY)*0.5f*factor);

        }

        factorDiagrammImage =  factor;
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
