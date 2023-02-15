package org.example.assignment1;

public class ManufacturedItem extends Item {
    public ManufacturedItem(String name, double price, int quantity) {
        super(name, price, quantity, ItemType.manufactured);
    }
}
