package org.example.assignment1;

public class Item {
    String name;
    double price;
    int quantity;
    String type;
    static double totalPrice = 0.0;

    //constructor
    Item(String name, double price, int quantity, String type){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        calculateTotal();
    }

    double calculateTax(){
        double tax = 0;
        if(this.type == "raw"){
            tax =  (0.125 * this.price);
        }
        else if(this.type == "manufactured"){
            tax = (0.125 * this.price);
            tax += (0.02 * tax);
        }
        else{
            double surcharge = 0;
            double importDuty = 0;
            tax = (0.125 * this.price);
            importDuty = 0.10 * this.price;
            double temp = tax + importDuty;
            if(temp <= 100){
                surcharge = 5;
            }
            if(temp > 100 && temp <= 200){
                surcharge = 10;
            }
            if(temp > 200){
                surcharge = 0.05 * temp;
            }
            tax = surcharge + temp;
        }
        return tax;
    }

    void calculateTotal(){
        totalPrice += (((double)(this.quantity * this.price)) + (this.calculateTax()));
    }

    void display(){
        double total = ((double)(this.price*this.quantity) + this.calculateTax());
        System.out.println(this.name+ "\t" + this.price + "\t" + this.quantity
                + "\t\t" + this.calculateTax() + "\t" + total);
    }
}
