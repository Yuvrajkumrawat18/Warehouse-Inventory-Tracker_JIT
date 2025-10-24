# Warehouse Inventory Tracker
* Efficiently manage and track inventory across multiple warehouses. *

## Project Description
The **Warehouse Inventory Tracker** is a Java-based console application designed to handle inventory across multiple warehouses efficiently.  
It allows users to:

- Receive new shipments and automatically update stock.
- Fulfill customer orders and adjust inventory in real-time.
- Track stock levels across multiple warehouse locations.

The project demonstrates **Object-Oriented Programming (OOP) concepts**, **Java Collections**, and **Multithreading** to simulate real-world warehouse operations. 

## Features
- Real-time inventory tracking across multiple warehouses  
- Add new shipments and fulfill orders with automatic stock updates  
- Separate stock records for each warehouse  
- Console-based interactive interface for easy management  
- Observer notifications for stock changes to simulate real-time alerts

## Key components:
- Product.java -> Holds product details (ID, name, quantity, reoderThreshold).
- StockObserver.java -> Interface defining how inventory alerts should be sent.
- ConsoleAlertService.java -> Implements alerts and displays messages on the console.
- Warehouse.java ->  Manages inventory, handles shipments and orders, and maintains stock levels.
- Main.java -> Entry point that runs the workflow and connects all components.

## Concepts Used

- Object-Oriented Programming: Encapsulation is used to protect product data,ensuring safe access via getters/   setters.
- Collections Framework : Java Collections (HashMap, ArrayList) are used to store and manage products efficiently.
- Observer Design Pattern : StockObserver acts as the observer interface, while ConsoleAlertService receives notifications.
- Exception Handling : Handles invalid operations, Ensures the program does not crash and provides informative error messages to the user.
- Multithreading : Simulates multiple warehouses updating inventory simultaneously.Ensures data consistency and thread-safe operations when managing stock in real-time.