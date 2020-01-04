package com.example.luhang.orderlistlogic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.luhang.orderlistlogic.adapter.OrderAdapter;
import com.example.luhang.orderlistlogic.bean.AllOrderBean;
import com.example.luhang.orderlistlogic.bean.GoodsOrderInfo;
import com.example.luhang.orderlistlogic.bean.OrderDataHelper;
import com.example.luhang.orderlistlogic.bean.OrderGoodsItem;
import com.example.luhang.orderlistlogic.bean.OrderSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WaitSend extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rlvWaitSend;
    private OrderAdapter mAllOrderAdapter;
    private View headerView;
    private List<Object> mAllOrderList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_send_layout);
        ActionBar actionBar = getSupportActionBar();
        Button BWait_pay = findViewById(R.id.wait_pay);
        Button BWait_get = findViewById(R.id.wait_get);
        Button BWait_evaluate = findViewById(R.id.wait_evaluate);
        Button BWait_send = findViewById(R.id.wait_send);
        Button All_order = findViewById(R.id.all_order);
        BWait_send.setTextColor(Color.RED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*if (actionBar != null) {
            actionBar.hide();
        }*/
        BWait_pay.setOnClickListener(this);
        BWait_get.setOnClickListener(this);
        BWait_evaluate.setOnClickListener(this);
        BWait_send.setOnClickListener(this);
        All_order.setOnClickListener(this);

        rlvWaitSend = (RecyclerView) findViewById(R.id.rlv_allorder);
        rlvWaitSend.setLayoutManager(new LinearLayoutManager(this));
        mAllOrderAdapter = new OrderAdapter(this, mAllOrderList, headerView);
        rlvWaitSend.setAdapter(mAllOrderAdapter);
        initData();
        mAllOrderAdapter.notifyDataSetChanged();
    }
    public boolean onCreateOptionsMenu(Menu menu)//创建菜单
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)//定义菜单响应时间
    {
        switch (item.getItemId())
        {
            case R.id.message_item:
                Toast.makeText(WaitSend.this,"You clicked message",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_item:
                Toast.makeText(WaitSend.this,"You clicked feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_item:
                Toast.makeText(WaitSend.this,"You clicked service",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_item:
                Toast.makeText(WaitSend.this,"You clicked main",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;

    }
    private void initData() {
        AllOrderBean allOrderBean = new AllOrderBean();
        OrderSummary orderSummary2 = new OrderSummary();
        OrderGoodsItem orderGoodsItem2 = new OrderGoodsItem();
        GoodsOrderInfo goodsOrderInfo2 = new GoodsOrderInfo();

        orderSummary2.setId(2);
        orderSummary2.setTotalPrice(13);
        orderSummary2.setStatus("1");
        orderSummary2.setOrderCode("2018111302");
        goodsOrderInfo2.setOrderCode("2018111302");
        goodsOrderInfo2.setStatus("1");//代发货
        goodsOrderInfo2.setShopName("贝养颂食品旗舰店");
        orderGoodsItem2.setTotalPrice(13);
        orderGoodsItem2.setProductName("营养早餐混合水果即食燕麦");
        orderGoodsItem2.setCount(1);
        orderGoodsItem2.setProductPic("https://i.loli.net/2019/07/05/5d1ec17d6b3b226474.jpg");
        orderGoodsItem2.setOrder(goodsOrderInfo2);


        List<OrderGoodsItem> orderGoodsItemList2 = new ArrayList<>();
        orderGoodsItemList2.add(orderGoodsItem2);
        orderSummary2.setOrderDetailList(orderGoodsItemList2);

        List<OrderSummary> orderSummaries = new ArrayList<>();
        orderSummaries.add(orderSummary2);
        allOrderBean.setResultList(orderSummaries);

        mAllOrderList.addAll(OrderDataHelper.getDataAfterHandle(allOrderBean.getResultList()));
    }
    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.all_order:
                Intent intent_all = new Intent(WaitSend.this,MainActivity.class);
                startActivity(intent_all);
                finish();
                break;
            case R.id.wait_pay:
                Intent intent_pay = new Intent(WaitSend.this,WaitPay.class);
                startActivity(intent_pay);
                finish();
                break;
            case R.id.wait_get:
                Intent intent_get = new Intent(WaitSend.this,WaitGet.class);
                startActivity(intent_get);
                finish();
                break;
            case R.id.wait_send:

                break;
            case R.id.wait_evaluate:
                Intent intent_evaluate= new Intent(WaitSend.this,WaitEvaluate.class);
                startActivity(intent_evaluate);
                finish();
                break;
            default:
                break;
        }
    }
}