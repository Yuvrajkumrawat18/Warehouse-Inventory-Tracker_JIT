package com.yuvraj.warehouse;
public class Product {

    private String productId;
    private String name;
    private int quantity;
    private int reoderThreshold;
    public Product (String productId, String name, int quantity, int reoderThreshold ){
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.reoderThreshold = reoderThreshold;
    }

    public String getProductId(){return productId;} 
    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public int getReoderThreshold(){return reoderThreshold;}

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}