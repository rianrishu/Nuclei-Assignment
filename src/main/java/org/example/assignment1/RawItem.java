package org.example.assignment1;

public class RawItem extends Item {
    RawItem(String name, double price, int quantity){
        super(name, price, quantity, ItemType.raw);
    }
}
