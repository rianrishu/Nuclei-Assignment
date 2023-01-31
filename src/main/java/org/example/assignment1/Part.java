package org.example.assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Part {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            char addMore;
            ArrayList<Item> items = new ArrayList<>();
            do {
                //Taking input from user
                System.out.print("Item Name : ");
                String name = sc.next();

                double price;
                while (true) {
                    try {
                        System.out.print("Item Price : ");
                        price = sc.nextDouble();
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Please add decimal number");
                        sc.nextLine();
                    }
                }

                int quantity;
                while (true) {
                    try {
                        System.out.print("Item Quantity : ");
                        quantity = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please add integer value");
                        sc.nextLine();
                    }
                }

                System.out.println("Available Item Types : ");
                System.out.println("1.Raw\n2.Manufactured\n3.Imported\n");

                int opt;
                ItemType type;
                System.out.print("Enter option ex:-(1, 2 or 3): ");
                opt = sc.nextInt();
                if (opt == 1) {
                    type = ItemType.raw;
                } else if (opt == 2) {
                    type = ItemType.manufactured;
                } else {
                    type = ItemType.imported;
                }

                items.add(new Item(name, price, quantity, type));
                System.out.println("Item Added !!");

                //continue to add more items
                System.out.print("Add more item(y/n) : ");
                addMore = sc.next().charAt(0);

            } while (addMore == 'y' || addMore == 'Y');

            //Generating the output
            double totalBill = 0.0;
            System.out.println("\n-----------All items in the list--------------\n");
            System.out.println("Name\tPrice\tQuantity\tTax\tFinal Price");
            for (var item : items) {
                System.out.println(item.toString());
                totalBill += item.calculateTotal();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Total Bill : " + totalBill);

        }
    }
}
