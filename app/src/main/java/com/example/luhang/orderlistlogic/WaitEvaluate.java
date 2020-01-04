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

public class WaitEvaluate extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rlvWaitEvaluate;
    private OrderAdapter mAllOrderAdapter;
    private View headerView;
    private List<Object> mAllOrderList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_evaluate_layout);
        ActionBar actionBar = getSupportActionBar();
        Button BWait_pay = findViewById(R.id.wait_pay);
        Button BWait_get = findViewById(R.id.wait_get);
        Button BWait_evaluate = findViewById(R.id.wait_evaluate);
        Button BWait_send = findViewById(R.id.wait_send);
        Button All_order = findViewById(R.id.all_order);
        BWait_evaluate.setTextColor(Color.RED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*if (actionBar != null) {
            actionBar.hide();
        }*/
        BWait_pay.setOnClickListener(this);
        BWait_get.setOnClickListener(this);
        BWait_evaluate.setOnClickListener(this);
        BWait_send.setOnClickListener(this);
        All_order.setOnClickListener(this);
        rlvWaitEvaluate = (RecyclerView) findViewById(R.id.rlv_allorder);
        rlvWaitEvaluate.setLayoutManager(new LinearLayoutManager(this));
        mAllOrderAdapter = new OrderAdapter(this, mAllOrderList, headerView);
        rlvWaitEvaluate.setAdapter(mAllOrderAdapter);
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
                Toast.makeText(WaitEvaluate.this,"You clicked message",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_item:
                Toast.makeText(WaitEvaluate.this,"You clicked feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_item:
                Toast.makeText(WaitEvaluate.this,"You clicked service",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_item:
                Toast.makeText(WaitEvaluate.this,"You clicked main",Toast.LENGTH_SHORT).show();
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
        OrderSummary orderSummary4 = new OrderSummary();
        OrderGoodsItem orderGoodsItem4 = new OrderGoodsItem();
        GoodsOrderInfo goodsOrderInfo4 = new GoodsOrderInfo();

        orderSummary4.setId(4);
        orderSummary4.setTotalPrice(3000);
        orderSummary4.setStatus("3");//待评价
        orderSummary4.setOrderCode("2016111303");
        goodsOrderInfo4.setOrderCode("2016111303");
        goodsOrderInfo4.setStatus("3");
        goodsOrderInfo4.setShopName("小米手机官方旗舰定");
        orderGoodsItem4.setTotalPrice(3000);
        orderGoodsItem4.setProductName("小米手机");
        orderGoodsItem4.setCount(1);
        orderGoodsItem4.setProductPic("https://i.loli.net/2019/07/05/5d1ec1b63675640322.jpg");
        orderGoodsItem4.setOrder(goodsOrderInfo4);

        List<OrderGoodsItem> orderGoodsItemList4 = new ArrayList<>();
        orderGoodsItemList4.add(orderGoodsItem4);
        orderSummary4.setOrderDetailList(orderGoodsItemList4);


        List<OrderSummary> orderSummaries = new ArrayList<>();
        orderSummaries.add(orderSummary4);
        allOrderBean.setResultList(orderSummaries);

        mAllOrderList.addAll(OrderDataHelper.getDataAfterHandle(allOrderBean.getResultList()));
    }
    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.all_order:
                Intent intent_all = new Intent(WaitEvaluate.this,MainActivity.class);
                startActivity(intent_all);
                finish();
                break;
            case R.id.wait_pay:
                Intent intent_pay = new Intent(WaitEvaluate.this,WaitPay.class);
                startActivity(intent_pay);
                finish();
                break;
            case R.id.wait_get:
                Intent intent_get = new Intent(WaitEvaluate.this,WaitGet.class);
                startActivity(intent_get);
                finish();
                break;
            case R.id.wait_send:
                Intent intent_send = new Intent(WaitEvaluate.this,WaitSend.class);
                startActivity(intent_send);
                finish();
                break;
            case R.id.wait_evaluate:

                break;
            default:
                break;
        }
    }
}
