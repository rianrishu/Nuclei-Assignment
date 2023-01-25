package org.example.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void testTaxValueRaw(){
        var obj1 = new Item("test1", 40, 4, "raw");
        assertEquals(5.000, obj1.calculateTax());
    }

    @Test
    void testTaxValueManufactured(){
        var obj1 = new Item("test", 40, 4, "manufactured");
        assertEquals(5.900, obj1.calculateTax());
    }

    @Test
    void testTaxValueImportedLessthan100(){
        var obj1 = new Item("test", 40, 4, "imported");

        assertEquals(14.000, obj1.calculateTax());
    }

    @Test
    void testTaxValueImportedBetween100and200(){
        var obj2 = new Item("test", 90, 7, "imported");
        assertEquals(30.250, obj2.calculateTax());
    }

    @Test
    void testTaxValueImportedMorethan200(){
        var obj1 = new Item("test", 190, 7, "imported");
        assertEquals(54.387, obj1.calculateTax());
    }
}