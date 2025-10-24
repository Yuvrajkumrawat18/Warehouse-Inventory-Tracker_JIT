package com.yuvraj.warehouse;
import java.sql.Struct;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Warehouse Inventory Started!");
        StockObserver alertservice = new ConsoleAlertService();
        List<String> warehouseNames = Arrays.asList("Delhi", "Mumbai", "Electronics");
        List<Warehouse> warehouses = new ArrayList<>();
        for(String name : warehouseNames){
            Warehouse w = new Warehouse(name, alertservice);
            w.loadInventoryFromFile();
            warehouses.add(w);

        }
        List<Thread> threads = new ArrayList<>();
        for (Warehouse w : warehouses){
            Thread t = new Thread(() -> {
                String id = "p" + new Random().nextInt(1000);
                w.addProduct(new Product (id, "Sample Product-" + w.getName(),0,5));
                w.receiveShipment(id, 10);
                w.fulfillOrder(id, 6);
            });
            threads.add(t);
            t.start();
        }
        for(Thread t : threads){
            try {
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        for( Warehouse w : warehouses){
            w.saveInventoryToFile();
        }
    }
}
