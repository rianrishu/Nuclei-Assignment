package org.example.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    ItemFactory itemFactory = ItemFactory.getItemFactoryInstance();
    @Test
    void testTaxValueRaw() {
        var obj1 = itemFactory.createItem("test1", 40, 4, ItemType.raw);
        assertEquals(5.000, obj1.calculateTax());
    }

    @Test
    void testTaxValueManufactured() {
        var obj1 = itemFactory.createItem("test", 40, 4, ItemType.manufactured);
        assertEquals(5.900, obj1.calculateTax());
    }

    @Test
    void testTaxValueImportedLessthan100() {
        var obj1 = itemFactory.createItem("test", 40, 4, ItemType.imported);

        assertEquals(14.000, obj1.calculateTax());
    }

    @Test
    void testTaxValueImportedBetween100and200() {
        var obj2 = itemFactory.createItem("test", 90, 7, ItemType.imported);
        assertEquals(30.250, obj2.calculateTax());
    }

    @Test
    void testTaxValueImportedMorethan200() {
        var obj1 = itemFactory.createItem("test", 190, 7, ItemType.imported);
        assertEquals(54.387, obj1.calculateTax());
    }

    @Test
    void testTotalValue() {
        var obj1 = itemFactory.createItem("test", 190, 7, ItemType.imported);
        assertEquals(1710.709, obj1.calculateTotal());
    }
}