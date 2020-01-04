package com.example.luhang.orderlistlogic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
//        Button titleBack = findViewById(R.id.title_back);
//        Button titleEdit = findViewById(R.id.title_edit);
        Button AllOrder = findViewById(R.id.all_order);
        Button WaitSend = findViewById(R.id.wait_send);
        Button WaitGet = findViewById(R.id.wait_get);
        Button WaitEvaluate = findViewById(R.id.wait_evaluate);
        Button WaitPay = findViewById(R.id.wait_pay);
        AllOrder.setBackgroundColor(Color.TRANSPARENT);
        WaitSend.setBackgroundColor(Color.TRANSPARENT);
        WaitGet.setBackgroundColor(Color.TRANSPARENT);
        WaitEvaluate.setBackgroundColor(Color.TRANSPARENT);
        WaitPay.setBackgroundColor(Color.TRANSPARENT);
        /*titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked Edit button",Toast.LENGTH_SHORT).show();
            }
        });*/

    }

}
