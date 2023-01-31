package org.example.assignment4;

import java.sql.*;
import java.util.ArrayList;

public class ReadCalculate {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/assignment4?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "nuclei@123";
    private ArrayList<Item> items;
    private int capacity = 100;

    private ArrayList<Item> calculateTax;

    private boolean exit = false;

    ReadCalculate(ArrayList<Item> items, ArrayList<Item> calculateTax) {
        this.items = items;
        this.calculateTax = calculateTax;
    }

    public void read() {

        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Reading from Database");
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Item");


            synchronized (this) {
                while (items.size() > capacity) {
                    System.out.println("IN read waiting");
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
                    System.out.println("reading");
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

    public void calculate() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (items.size() == 0 && exit == false) {
                    try {
                        System.out.println("in calculate waiting");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (items.size() != 0) {
                    Item item = items.remove(0);
                    item.setTax();
                    item.setItemFinalPrice();
                    calculateTax.add(item);
                    System.out.println("calculating");
                    notify();
                    Thread.sleep(1);
                } else {
                    break;
                }
            }
        }
    }
}
