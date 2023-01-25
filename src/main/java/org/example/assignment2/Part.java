package org.example.assignment2;

import java.io.*;
import java.util.*;

public class Part {
    static ArrayList<User> user;
    static Set<Integer> rollset;

    static void takeInput(){
        Scanner sc = new Scanner(System.in);
        String name, address;
        int rollno, age;

        ArrayList<Character> courses = new ArrayList<Character>();

        System.out.print("Enter name : ");
        name = sc.nextLine();

        System.out.print("Enter age : ");
        age = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter address : ");
        address = sc.nextLine();

        System.out.print("Enter rollno : ");
        rollno = sc.nextInt();

        System.out.print("Enter number of courses : ");
        int temp = sc.nextInt();
        if(temp < 4 || temp > 6){
            System.out.println("Number of courses must be between 4 and 6");
            System.out.print("Enter number of courses : ");
            temp = sc.nextInt();
        }

        sc.nextLine();
        System.out.print("Enter " + temp + " courses : ");
        for(int i=0; i<temp; i++){
            char c = sc.next().charAt(0);
            courses.add(c);
        }
        System.out.println("courses added");
        if(!rollset.contains(rollno)){
            User u = new User(name, age, address, rollno, courses);
            user.add(u);
            rollset.add(rollno);
            System.out.println("User added successfully\n");
        }
        else{
            System.out.println("User already exists\n");;
        }
        return;

    }

    static void display(){
        System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
        System.out.println("---------------------------------------------------------------");
        for(int i=0; i<user.size(); i++){
            user.get(i).display();
        }
    }

    static void displayUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------User Details------------------------");
        display();
        System.out.print("Would you like to sort the result(y/n) : ");
        char option = sc.next().charAt(0);
        if(option == 'y'){
            while(true){
                System.out.println("Sort according to : ");
                System.out.println("1.Name\n2.Roll No.\n3.Age\n4.Address\n5.Exit sorting");
                System.out.print("Enter option : ");
                int opt = sc.nextInt();
                if(opt == 1){
                    Collections.sort (user, new NameComparator());
                    display();
                }
                if(opt == 2){
                    Collections.sort (user, new RollComparator());
                    display();
                }
                if(opt == 3){
                    Collections.sort (user, new AgeComparator());
                    display();
                }
                if(opt == 4){
                    Collections.sort (user, new AddressComparator());
                    display();
                }
                if(opt == 5){
                    break;
                }
            }
        }

    }

    static void deleteUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No. of user to deleted : ");
        int delroll = sc.nextInt();
        if(rollset.contains(delroll)){
            for(var u : user){
                if(u.rollno == delroll){
                    user.remove(u);
                    break;
                }
            }
            System.out.println("User deleted successfully!!");
        }
        else{
            System.out.println("User doesn't exists");
        }
    }

    static void saveDetails() throws IOException{
        //Serializing the data
        try {
            FileOutputStream fileout = new FileOutputStream("out.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            for(var u : user){
                out.writeObject(u);
            }
            out.close();
            fileout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nUser details saved to file out.txt\n");

        System.out.println("\nReading the data from file\n");

        //Deserializing the data
        ArrayList<User> fileread = new ArrayList<User>();
        try{
            FileInputStream filein = new FileInputStream("out.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            for(int i=0; i<user.size(); i++){
                User u = (User)in.readObject();
                fileread.add(u);
            }
            in.close();
            filein.close();

        }
        catch(IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
            System.out.println("---------------------------------------------------------------");
            for(var u : fileread){
                u.display();
            }
        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        rollset = new HashSet<Integer>();
        user = new ArrayList<User>();
        while(true){
            System.out.println("1.Add user details\n2.Display user details\n3.Delete user details\n4.Save user details\n5.Exit\n");
            System.out.print("Choose an option : ");
            int option = sc.nextInt();
            if(option == 1){
                takeInput();
            }
            if(option == 2){
                displayUser();
            }
            if(option == 3){
                deleteUser();
            }
            if(option == 4){
                try {
                    saveDetails();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(option == 5){
                return;
            }
        }
    }
}
