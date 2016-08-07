package com.example.afomic.group;

import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by afomic on 24-Jul-16.
 */
public class GotoPlaces extends ClickableSpan {
    Class going;
    public GotoPlaces(Class whereTo){
        going=whereTo;
    }
    @Override
    public void onClick(View widget) {
        Context context= widget.getContext();
        Intent intent=new Intent(context,going);
        context.startActivity(intent);
    }
}
