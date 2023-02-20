package org.example.assignment4;

import java.sql.*;
import java.util.ArrayList;

public class ReadDBCalculateTax {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/assignment4?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "nuclei@123";
    private ArrayList<Item> items;
    private int capacity = 100;

    private ArrayList<Item> calculateItemsTax;

    private boolean exit = false;

    ReadDBCalculateTax(ArrayList<Item> items, ArrayList<Item> calculateItemsTax) {
        this.items = items;
        this.calculateItemsTax = calculateItemsTax;
    }

    public void readItems() {

        Connection connection;
        Statement statement;

        try {
            System.out.println("Reading from Database");
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Item");


            synchronized (this) {
                while (items.size() > capacity) {
                    wait();
                }
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    String stype = resultSet.getString("type");
                    ItemType etype = ItemType.valueOf(stype);
                    Item item = new Item(name, price, quantity, etype);
                    items.add(item);
                    notify();
                    Thread.sleep(1);
                }
            }
            exit = true;
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateTax() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (items.size() == 0 && exit == false) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Runtime exception");
                        System.out.println("Error message : " + e.getMessage());
                    }
                }
                if (items.size() != 0) {
                    Item item = items.remove(0);
                    item.setTax();
                    item.setItemFinalPrice();
                    calculateItemsTax.add(item);
                    notify();
                    Thread.sleep(1);
                } else {
                    break;
                }
            }
        }
    }
}
