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

public class WaitGet extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rlvWaitGet;
    private OrderAdapter mAllOrderAdapter;
    private View headerView;
    private List<Object> mAllOrderList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_get_layout);
        ActionBar actionBar = getSupportActionBar();
        Button BWait_pay = findViewById(R.id.wait_pay);
        Button BWait_get = findViewById(R.id.wait_get);
        Button BWait_evaluate = findViewById(R.id.wait_evaluate);
        Button BWait_send = findViewById(R.id.wait_send);
        Button All_order = findViewById(R.id.all_order);
        BWait_get.setTextColor(Color.RED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*if (actionBar != null) {
            actionBar.hide();
        }*/
        BWait_pay.setOnClickListener(this);
        BWait_get.setOnClickListener(this);
        BWait_evaluate.setOnClickListener(this);
        BWait_send.setOnClickListener(this);
        All_order.setOnClickListener(this);

        rlvWaitGet = (RecyclerView) findViewById(R.id.rlv_allorder);
        rlvWaitGet.setLayoutManager(new LinearLayoutManager(this));
        mAllOrderAdapter = new OrderAdapter(this, mAllOrderList, headerView);
        rlvWaitGet.setAdapter(mAllOrderAdapter);
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
                Toast.makeText(WaitGet.this,"You clicked message",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_item:
                Toast.makeText(WaitGet.this,"You clicked feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_item:
                Toast.makeText(WaitGet.this,"You clicked service",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_item:
                Toast.makeText(WaitGet.this,"You clicked main",Toast.LENGTH_SHORT).show();
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
        OrderSummary orderSummary3 = new OrderSummary();
        OrderGoodsItem orderGoodsItem3 = new OrderGoodsItem();
        GoodsOrderInfo goodsOrderInfo3 = new GoodsOrderInfo();

        orderSummary3.setId(3);
        orderSummary3.setTotalPrice(113);
        orderSummary3.setStatus("2");//待收货
        orderSummary3.setOrderCode("20180711399");
        goodsOrderInfo3.setOrderCode("20180711399");
        goodsOrderInfo3.setStatus("2");
        goodsOrderInfo3.setShopName("百雀羚官方旗舰店");
        orderGoodsItem3.setTotalPrice(113);
        orderGoodsItem3.setProductName("百雀羚护肤套装");
        orderGoodsItem3.setCount(1);
        orderGoodsItem3.setProductPic("https://i.loli.net/2019/07/05/5d1ec1cdd965721639.jpeg");
        orderGoodsItem3.setOrder(goodsOrderInfo3);

        List<OrderGoodsItem> orderGoodsItemList3 = new ArrayList<>();
        orderGoodsItemList3.add(orderGoodsItem3);
        orderSummary3.setOrderDetailList(orderGoodsItemList3);


        List<OrderSummary> orderSummaries = new ArrayList<>();
        orderSummaries.add(orderSummary3);
        allOrderBean.setResultList(orderSummaries);

        mAllOrderList.addAll(OrderDataHelper.getDataAfterHandle(allOrderBean.getResultList()));
    }
    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.all_order:
                Intent intent_all = new Intent(WaitGet.this,MainActivity.class);
                startActivity(intent_all);
                finish();
                break;
            case R.id.wait_pay:
                Intent intent_pay = new Intent(WaitGet.this,WaitPay.class);
                startActivity(intent_pay);
                finish();
                break;
            case R.id.wait_get:

                break;
            case R.id.wait_send:
                Intent intent_send = new Intent(WaitGet.this,WaitSend.class);
                startActivity(intent_send);
                finish();
                break;
            case R.id.wait_evaluate:
                Intent intent_evaluate= new Intent(WaitGet.this,WaitEvaluate.class);
                startActivity(intent_evaluate);
                finish();
                break;
            default:
                break;
        }
    }
}
