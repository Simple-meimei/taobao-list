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

public class WaitPay extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rlvWaitPay;
    private OrderAdapter mAllOrderAdapter;
    private View headerView;
    private List<Object> mAllOrderList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_pay_layout);
        ActionBar actionBar = getSupportActionBar();
        Button BWait_pay = findViewById(R.id.wait_pay);
        Button BWait_get = findViewById(R.id.wait_get);
        Button BWait_evaluate = findViewById(R.id.wait_evaluate);
        Button BWait_send = findViewById(R.id.wait_send);
        Button All_order = findViewById(R.id.all_order);
        BWait_pay.setTextColor(Color.RED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*if (actionBar != null) {
            actionBar.hide();
        }*/
        BWait_pay.setOnClickListener(this);
        BWait_get.setOnClickListener(this);
        BWait_evaluate.setOnClickListener(this);
        BWait_send.setOnClickListener(this);
        All_order.setOnClickListener(this);

        rlvWaitPay = (RecyclerView) findViewById(R.id.rlv_allorder);
        rlvWaitPay.setLayoutManager(new LinearLayoutManager(this));
        mAllOrderAdapter = new OrderAdapter(this, mAllOrderList, headerView);
        rlvWaitPay.setAdapter(mAllOrderAdapter);
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
                Toast.makeText(WaitPay.this,"You clicked message",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_item:
                Toast.makeText(WaitPay.this,"You clicked feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_item:
                Toast.makeText(WaitPay.this,"You clicked service",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_item:
                Toast.makeText(WaitPay.this,"You clicked main",Toast.LENGTH_SHORT).show();
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
        OrderSummary orderSummary1 = new OrderSummary();
        OrderGoodsItem orderGoodsItem1 = new OrderGoodsItem();
        GoodsOrderInfo goodsOrderInfo1 = new GoodsOrderInfo();

        orderSummary1.setId(1);
        orderSummary1.setTotalPrice(10);
        orderSummary1.setStatus("0");
        orderSummary1.setOrderCode("2018111301");
        goodsOrderInfo1.setOrderCode("2018111301");
        goodsOrderInfo1.setStatus("0");//代付款
        goodsOrderInfo1.setShopName("永康伞灵特价区");
        orderGoodsItem1.setTotalPrice(5);
        orderGoodsItem1.setProductName("折叠创意黑胶防紫外线可爱韩版太阳伞");
        orderGoodsItem1.setCount(2);
        orderGoodsItem1.setProductPic("https://i.loli.net/2019/07/05/5d1ec12be926e47013.jpg");
        orderGoodsItem1.setOrder(goodsOrderInfo1);

        List<OrderGoodsItem> orderGoodsItemList = new ArrayList<>();
        orderGoodsItemList.add(orderGoodsItem1);
        orderSummary1.setOrderDetailList(orderGoodsItemList);


        List<OrderSummary> orderSummaries = new ArrayList<>();
        orderSummaries.add(orderSummary1);
        allOrderBean.setResultList(orderSummaries);

        mAllOrderList.addAll(OrderDataHelper.getDataAfterHandle(allOrderBean.getResultList()));
    }
    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.all_order:
                Intent intent_all = new Intent(WaitPay.this,MainActivity.class);
                startActivity(intent_all);
                finish();
                break;
            case R.id.wait_pay:

                break;
            case R.id.wait_get:
                Intent intent_get = new Intent(WaitPay.this,WaitGet.class);
                startActivity(intent_get);
                finish();
                break;
            case R.id.wait_send:
                Intent intent_send = new Intent(WaitPay.this,WaitSend.class);
                startActivity(intent_send);
                finish();
                break;
            case R.id.wait_evaluate:
                Intent intent_evaluate= new Intent(WaitPay.this,WaitEvaluate.class);
                startActivity(intent_evaluate);
                finish();
                break;
            default:
                break;
        }
    }
}
