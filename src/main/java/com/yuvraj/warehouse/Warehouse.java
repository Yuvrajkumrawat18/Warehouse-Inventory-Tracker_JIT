package com.yuvraj.warehouse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private String name;
    private Map<String,Product> products = new HashMap<>();
    private StockObserver alertservice;
    public Warehouse (String name, StockObserver alertservice){
                  this.name = name;
                  this.alertservice = alertservice;
    }
    public synchronized void addProduct(Product product){
        if (products.containsKey(product.getProductId())) {
            System.out.println("ProductID" + product.getProductId() + "already exists!" );
        }
         else {
            products.put(product.getProductId(), product);
            System.out.println(name + "Product added:" + product.getName());
         }
        
    }
    public synchronized void receiveShipment(String ProductID, int quantity){
        Product product = products.get(ProductID);
        if (product == null) {
            System.out.println(name + "Invalid  Product ID:" + ProductID);
            return;
        }
        product.setQuantity(product.getQuantity() + quantity);
        System.out.println( name + "Shipment Received For " + product.getName() + "+" + quantity + "Total:" + product.getQuantity());
    }
    public synchronized void fulfillOrder(String productId, int quantity){
        Product product = products.get(productId);
        if (product == null){
            System.out.println( name + "Invalid Product ID" + productId);
            return;
        }
        if (product.getQuantity() < quantity) {
            
         System.out.println(name + "Insufficient Stock for " + product.getName());
         return;
        }
        product.setQuantity(product.getQuantity() - quantity);
        System.out.println(name + " Oder fulfilled for " + product.getName() + "-" + quantity + "Remaining " + product.getQuantity());
        if (product.getQuantity() < product.getReoderThreshold()) {
            alertservice.onLowStock(product);
        }
    }
  public synchronized void saveInventoryToFile(){
    try(FileWriter writer = new FileWriter(name + "_inventory.txt")){
        for (Product  p : products.values()) {
         writer.write(p.getProductId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getReoderThreshold() + "\n");
            }
            System.out.println( name + " Inventory saved.");
        } catch (IOException e) {
            System.out.println( name + " Error saving inventory: " + e.getMessage());
        }
    }
     public synchronized void loadInventoryFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(name + "_inventory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Product p = new Product(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                products.put(p.getProductId(), p);
            }
            System.out.println( name + " Inventory loaded.");
        } catch (IOException e) {
            System.out.println( name + "Error loading inventory: " + e.getMessage());
        }
    }
    public String getName() {
    return name;
}

  }

