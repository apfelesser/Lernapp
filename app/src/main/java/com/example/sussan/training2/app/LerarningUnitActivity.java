package com.example.sussan.training2.app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by Sussan on 03.05.2016.
 */
public class LerarningUnitActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
/*                    Button myButton = new Button(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    myButton.setLayoutParams(params);
                    myButton.setText("hallooo");*/

      /*              LinearLayout mainLayout = (LinearLayout)findViewById(R.id.learningunitcontainer);

                    *//***** Container ****//*
                    LinearLayout container = new LinearLayout(this);
                    container.setOrientation(LinearLayout.VERTICAL);
                    container.addView(myButton);

                    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params2.height = (540 - 2*16);
                    container.setLayoutParams(params2);
                    //ImageView diagrammImageView = new ImageView(this);
                    //diagrammImageView.setImageResource(R.drawable.testskizze2);
                    //container.addView(diagrammImageView);*/



       /*             BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Lernapp/testskizze3.png", options);
                    Drawable d = new BitmapDrawable(getResources(), bitmap);*/

                           // API!! setBackgroundDrawable

                /*
                        DisplayMetrics metrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplsay().getMetrics(metrics);

                        Log.e("DisplayMetricsWidth", "is" + metrics.widthPixels);
                        Log.e("DisplayMetricsHeight", "is" + metrics.heightPixels);

                        float widthFactor1 = (metrics.widthPixels / 800);
                        float heightFactor1 = (metrics.heightPixels / 800);

                       int widthFactor =  (int) Math.round(widthFactor1);
                       int heightFactor =  (int) Math.round(heightFactor1);

                        Button button1 = new Button(this);
                        button1.setText("haaaaalllloooooo");
                        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params3.leftMargin = 200;
                        params3.rightMargin = 300;


                        button1.setLayoutParams(params3);
                       container.addView(button1);
                        Log.e("DisplayMetricsHeight", "lalalal");

                        container.setBackground(d);


                        mainLayout.addView(container);*/


        /*ImageView diagrammView = (ImageView)findViewById(R.id.DiagrammImage);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Lernapp/quadrate.png", options);
*/



        super.onCreate(savedInstanceState);

        setContentView(R.layout.learningunit_layout);

        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.learningunitcontainer);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        SchematicModeLearning schematicView = new SchematicModeLearning();


//        DiagrammView diagramm = new DiagrammView(this);

       if(mainLayout == null)
        {
            Log.e("LearingActivity", "Null");
        }
         else {
           String s = "/storage/emulated/0/Pictures/Lernapp/quadrate.png";
           int w =metrics.widthPixels;
           int h= metrics.heightPixels;
           //int p = mainLayout.getPaddingLeft();
            int p = 24;
           Log.e("LearingActivity", "parameter");

           //mainLayout = schematicView.createLayoutOfDiagramm(mainLayout, w, h, p);
           mainLayout = schematicView.initTextToLearn(mainLayout);

           if(mainLayout == null)
           {
               Log.e("LearingActivity", "mist null");
           }
           else
           {
               Log.e("MARK", "else");
           }

        }


    }

}
