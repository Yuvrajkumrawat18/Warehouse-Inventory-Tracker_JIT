package com.yuvraj.warehouse;
import com.yuvraj.warehouse.Product;


public class ConsoleAlertService implements StockObserver{
    @Override
    public  void onLowStock(Product product){
        System.out.println("Restock [Alert]: Low Stock for " + product.getName() + " Only " + product.getQuantity() + " Left!");
    }
}
