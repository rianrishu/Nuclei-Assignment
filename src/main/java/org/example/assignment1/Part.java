package org.example.assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

class Part{
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            char cont = 'y';
            Item[] items = new Item[1000];
            int i = 0;
            do{
                try{

                    //Taking input from user
                    System.out.print("Item Name : ");
                    String name = sc.next();
                    System.out.print("Item Price : ");
                    double price = sc.nextDouble();
                    System.out.print("Item Quantity : ");
                    int quantity = sc.nextInt();
                    System.out.print("Item Type : ");
                    String type = sc.next();

                    if(type == "raw" || type == "manufactured" || type != "imported"){
                        items[i++] = new Item(name, price, quantity, type);
                        System.out.println("Item Added !!");
                    }
                    else{
                        System.out.println("Item type not appropriate");
                    }

                    //continue to add more items
                    System.out.print("Add more item(y/n) : ");
                    cont = sc.next().charAt(0);

                } catch(InputMismatchException e){
                    System.out.println("Add decimal number");
                    sc.nextLine();
                }
            }
            while(cont == 'y');

            //Generating the output
            System.out.println("\n-----------All items in the list--------------\n");
            System.out.println("Name\tPrice\tQuantity\tTax\tFinal Price");
            for(int j=0; j<i; j++){
                items[j].display();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Total price : " + Item.totalPrice);
        }
    }
}
