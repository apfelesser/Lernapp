package com.example.sussan.training2.app;

import android.widget.Button;

/**
 * Created by Sussan on 22.05.2016.
 */
public class Card{

    public int x;
    public int y;
    public Button button;

    public Card(Button button, int x,int y) {
        this.x = x;
        this.y=y;
        this.button=button;
    }


}
