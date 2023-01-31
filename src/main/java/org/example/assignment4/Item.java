package org.example.assignment4;

enum ItemType {
    raw, manufactured, imported
}

public class Item {
    private String name;
    private double price;
    private int quantity;
    private ItemType type;
    private double tax;
    private double itemFinalPrice;

    //constructor
    Item(String name, double price, int quantity, ItemType type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    void setTax() {
        this.tax = this.calculateTax();
    }

    void setItemFinalPrice() {
        this.itemFinalPrice = this.calculateTotal();
    }

    double getTax() {
        return tax;
    }

    double calculateTax() {
        double tax = (0.125 * this.price);
        switch (this.type) {
            case manufactured:
                tax += (0.02 * (tax + this.price));
                break;
            case imported:
                double surcharge = 5.0;
                double importDuty = 0.10 * this.price;
                double addTaxImportPrice = tax + importDuty + this.price;
                if (addTaxImportPrice > 100 && addTaxImportPrice <= 200) {
                    surcharge = 10;
                } else if (addTaxImportPrice > 200) {
                    surcharge = 0.05 * addTaxImportPrice;
                }
                tax = surcharge + addTaxImportPrice - this.price;
                break;
        }
        return Math.round(tax * 1000) / 1000.0;
    }

    double calculateTotal() {
        return ((this.calculateTax() + this.price) * this.quantity);
    }

    @Override
    public String toString() {
        String str = String.format("%s\t%.3f\t%d\t\t%.3f\t%.3f", this.name, this.price, this.quantity,
                this.tax, this.itemFinalPrice);
        return str;
    }
}
