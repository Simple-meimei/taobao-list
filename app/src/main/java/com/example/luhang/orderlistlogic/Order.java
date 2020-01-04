package com.example.luhang.orderlistlogic;
//RecycleView的一个适配器类
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;
import java.io.Serializable;

public class Order extends LitePalSupport implements Serializable{
    private int id;
    private String OrderCode;
    private String ShopName;
    private String ProductName;
    private int count;
    private float price;
    private float TotalPrice;
    private String ProductPic;

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductPic(String productPic) {
        ProductPic = productPic;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public int getCount() {
        return count;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductPic() {
        return ProductPic;
    }

    public String getShopName() {
        return ShopName;
    }
}
