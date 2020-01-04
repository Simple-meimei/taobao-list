package com.example.luhang.orderlistlogic.bean;

import java.util.List;


public class AllOrderBean {



    private int pageSize;
    private int pageNo;
    private int rowCount;
    private int pageCount;
    private List<Integer> pageSizeList;


    private List<com.example.luhang.orderlistlogic.bean.OrderSummary> resultList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Integer> getPageSizeList() {
        return pageSizeList;
    }

    public void setPageSizeList(List<Integer> pageSizeList) {
        this.pageSizeList = pageSizeList;
    }

    public List<OrderSummary> getResultList() {
        return resultList;
    }

    public void setResultList(List<OrderSummary> resultList) {
        this.resultList = resultList;
    }


}
