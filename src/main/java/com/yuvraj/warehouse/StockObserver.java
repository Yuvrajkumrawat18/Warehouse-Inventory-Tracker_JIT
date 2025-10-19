package com.yuvraj.warehouse;

public interface StockObserver  {
    void onLowStock(Product product);
}