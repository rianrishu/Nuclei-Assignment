package org.example.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Multithreading {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assignment4?characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "nuclei@123";

    void addEntries() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to Database");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            String sql;
            Random rand = new Random();
            String[] types = {"raw", "manufactured", "imported"};
            for (int i = 1; i <= 10000; i++) {
                String name = "Product " + i;
                double price = rand.nextDouble() * 100;
                price = Math.round(price * 1000) / 1000.0;
                int quantity = 1 + rand.nextInt(9);
                String type = types[rand.nextInt(types.length)];
                sql = "INSERT INTO Item (id, name, price, quantity, type) VALUES (" + i +
                        ", '" + name + "', " + price + ", " + quantity + ", '" + type + "')";
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Item> calculatedTax = new ArrayList<>();

        ReadCalculate readCalculate = new ReadCalculate(itemList, calculatedTax);

        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                readCalculate.read();
            }
        });

        Thread calculate = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readCalculate.calculate();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        read.start();
        calculate.start();

        read.join();
        calculate.join();

        for (var item : calculatedTax) {
            System.out.println(item.toString());
        }
    }
}
