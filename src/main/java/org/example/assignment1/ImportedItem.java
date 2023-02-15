package org.example.assignment1;

public class ImportedItem extends Item {
    public ImportedItem(String name, double price, int quantity) {
        super(name, price, quantity, ItemType.imported);
    }
}
