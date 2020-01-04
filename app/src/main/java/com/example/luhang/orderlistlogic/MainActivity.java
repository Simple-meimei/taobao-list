package com.example.luhang.orderlistlogic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.support.v7.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.luhang.orderlistlogic.adapter.OrderAdapter;
import com.example.luhang.orderlistlogic.bean.AllOrderBean;
import com.example.luhang.orderlistlogic.bean.GoodsOrderInfo;
import com.example.luhang.orderlistlogic.bean.OrderDataHelper;
import com.example.luhang.orderlistlogic.bean.OrderGoodsItem;
import com.example.luhang.orderlistlogic.bean.OrderSummary;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rlvAllOrder;
    private OrderAdapter  mAllOrderAdapter;
    private View headerView;
    private List<Object> mAllOrderList = new ArrayList<>();
    private Object SearchView;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        Button BWait_pay = findViewById(R.id.wait_pay);
        Button BWait_get = findViewById(R.id.wait_get);
        Button BWait_evaluate = findViewById(R.id.wait_evaluate);
        Button BWait_send = findViewById(R.id.wait_send);
        Button All_order = findViewById(R.id.all_order);
        All_order.setTextColor(Color.RED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        /*if (actionBar != null) {
            actionBar.hide();
        }*/
        BWait_pay.setOnClickListener(this);
        BWait_get.setOnClickListener(this);
        BWait_evaluate.setOnClickListener(this);
        BWait_send.setOnClickListener(this);
        All_order.setOnClickListener(this);

        rlvAllOrder = (RecyclerView) findViewById(R.id.rlv_allorder);
        rlvAllOrder.setLayoutManager(new LinearLayoutManager(this));
        mAllOrderAdapter = new OrderAdapter(this, mAllOrderList, headerView);
        rlvAllOrder.setAdapter(mAllOrderAdapter);
        initData();
        mAllOrderAdapter.notifyDataSetChanged();

    }
    public boolean onCreateOptionsMenu(Menu menu)//创建菜单
    {
        getMenuInflater().inflate(R.menu.main,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView  = (SearchView) MenuItemCompat.getActionView(menuItem);
        //设置搜索的事件
        ((android.support.v7.widget.SearchView) SearchView).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast t = Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP,0,0);
                t.show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)//定义菜单响应时间
    {
        switch (item.getItemId())
        {
            case R.id.message_item:
                Toast.makeText(MainActivity.this,"You clicked message",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_item:
                Toast.makeText(MainActivity.this,"You clicked feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_item:
                Toast.makeText(MainActivity.this,"You clicked service",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_item:
                Toast.makeText(MainActivity.this,"You clicked main",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;

    }
    private void initData() {
        //整个页面类
        AllOrderBean allOrderBean = new AllOrderBean();
        //大订单类，订单编号，总价，创建时间，状态
        OrderSummary orderSummary1 = new OrderSummary();
        OrderSummary orderSummary2 = new OrderSummary();
        OrderSummary orderSummary3 = new OrderSummary();
        OrderSummary orderSummary4 = new OrderSummary();
        //小订单中的商品类
        OrderGoodsItem orderGoodsItem1 = new OrderGoodsItem();
        OrderGoodsItem orderGoodsItem2 = new OrderGoodsItem();
        OrderGoodsItem orderGoodsItem3 = new OrderGoodsItem();
        OrderGoodsItem orderGoodsItem4 = new OrderGoodsItem();
        //每个小订单的头部信息（订单号、订单状态、店铺名称）
        GoodsOrderInfo goodsOrderInfo1 = new GoodsOrderInfo();
        GoodsOrderInfo goodsOrderInfo2 = new GoodsOrderInfo();
        GoodsOrderInfo goodsOrderInfo3 = new GoodsOrderInfo();
        GoodsOrderInfo goodsOrderInfo4 = new GoodsOrderInfo();

        //创建数据库
        Order order = new Order();
        order.setId(1);
        order.setTotalPrice(30);//总价
        order.setShopName("永康伞灵特价区");//店铺名
        order.setProductName("折叠创意黑胶防紫外线可爱韩版太阳伞");//商品名
        order.setCount(2);//数量
        order.setProductPic("https://i.loli.net/2019/07/05/5d1ec12be926e47013.jpg");
        order.setPrice(15);//单价
        order.save();

        orderSummary1.setId(1);
        orderSummary1.setTotalPrice(10);
        orderSummary1.setStatus("0");
        orderSummary1.setOrderCode("517601219029556301");
        goodsOrderInfo1.setOrderCode("517601219029556301");
        goodsOrderInfo1.setStatus("0");//代付款
        goodsOrderInfo1.setShopName("永康伞灵特价区");
        orderGoodsItem1.setTotalPrice(5);
        orderGoodsItem1.setProductName("折叠创意黑胶防紫外线可爱韩版太阳伞");
        orderGoodsItem1.setCount(2);
        orderGoodsItem1.setProductPic("https://i.loli.net/2019/07/05/5d1ec12be926e47013.jpg");
        orderGoodsItem1.setOrder(goodsOrderInfo1);

        List<OrderGoodsItem> orderGoodsItemList1 = new ArrayList<>();
        orderGoodsItemList1.add(orderGoodsItem1);
        orderSummary1.setOrderDetailList(orderGoodsItemList1);

        orderSummary2.setId(2);
        orderSummary2.setTotalPrice(13);
        orderSummary2.setStatus("1");
        orderSummary2.setOrderCode("512042017200556301");
        goodsOrderInfo2.setOrderCode("512042017200556301");
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

        orderSummary3.setId(3);
        orderSummary3.setTotalPrice(113);
        orderSummary3.setStatus("2");//待收货
        orderSummary3.setOrderCode("510833058420556301");
        goodsOrderInfo3.setOrderCode("510833058420556301");
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

        orderSummary4.setId(4);
        orderSummary4.setTotalPrice(3000);
        orderSummary4.setStatus("3");//待评价
        orderSummary4.setOrderCode("306605198298556301");
        goodsOrderInfo4.setOrderCode("306605198298556301");
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
        orderSummaries.add(orderSummary1);
        orderSummaries.add(orderSummary2);
        orderSummaries.add(orderSummary3);
        orderSummaries.add(orderSummary4);
        allOrderBean.setResultList(orderSummaries);

        mAllOrderList.addAll(OrderDataHelper.getDataAfterHandle(allOrderBean.getResultList()));
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.all_order:
                break;
            case R.id.wait_pay:
                Intent intent_pay = new Intent(MainActivity.this,WaitPay.class);
                startActivity(intent_pay);
                break;
            case R.id.wait_get:
                Intent intent_get = new Intent(MainActivity.this,WaitGet.class);
                startActivity(intent_get);
                break;
            case R.id.wait_send:
                Intent intent_send = new Intent(MainActivity.this,WaitSend.class);
                startActivity(intent_send);
                break;
            case R.id.wait_evaluate:
                Intent intent_evaluate= new Intent(MainActivity.this,WaitEvaluate.class);
                startActivity(intent_evaluate);
                break;
            default:
                break;
        }
    }
}

