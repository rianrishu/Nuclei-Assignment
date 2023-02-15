package org.example.assignment1;


public class ItemFactory {
    private static ItemFactory itemFactory = new ItemFactory();
    private ItemFactory(){

    }

    public static ItemFactory getItemFactoryInstance(){
        return itemFactory;
    }
    public Item createItem(String name, double price, int quantity, ItemType type) {
        switch(type) {
            case raw:
                return new RawItem(name, price, quantity);
            case manufactured:
                return new ManufacturedItem(name, price, quantity);
            case imported:
                return new ImportedItem(name, price, quantity);
            default:
                throw new IllegalArgumentException("Invalid item type.");
        }
    }
}
