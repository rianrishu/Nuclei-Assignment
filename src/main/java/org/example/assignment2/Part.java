package org.example.assignment2;

import java.io.*;
import java.util.*;

public class Part {

    User takeInput(Set<Integer> rollset) {
        Scanner sc = new Scanner(System.in);
        String name, address;
        int rollno, age;

        ArrayList<Character> courses = new ArrayList<>();

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
        if (temp < 4 || temp > 6) {
            System.out.println("Number of courses must be between 4 and 6");
            System.out.print("Enter number of courses : ");
            temp = sc.nextInt();
        }

        sc.nextLine();
        System.out.print("Enter " + temp + " courses : ");
        for (int i = 0; i < temp; i++) {
            char c = sc.next().charAt(0);
            courses.add(c);
        }
        System.out.println("courses added");

        User result = null;
        if (!rollset.contains(rollno)) {
            result = new User(name, age, address, rollno, courses);
            rollset.add(rollno);
            System.out.println("User added successfully\n");
        } else {
            System.out.println("User already exists\n");
        }
        return result;
    }

    void display(ArrayList<User> user) {
        System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
        System.out.println("---------------------------------------------------------------");
        for (var u : user) {
            System.out.println(u.toString());
        }
    }

    void displayUser(ArrayList<User> user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------User Details------------------------");
        display(user);
        System.out.print("Would you like to sort the result(y/n) : ");
        char option = sc.next().charAt(0);
        if (option == 'y') {
            while (true) {
                System.out.println("Sort according to : ");
                System.out.println("1.Name\n2.Roll No.\n3.Age\n4.Address\n5.Exit sorting");
                System.out.print("Enter option : ");
                int opt = sc.nextInt();
                if (opt == 1) {
                    user.sort(new NameComparator());
                    display(user);
                }
                if (opt == 2) {
                    user.sort(new RollComparator());
                    display(user);
                }
                if (opt == 3) {
                    user.sort(new AgeComparator());
                    display(user);
                }
                if (opt == 4) {
                    user.sort(new AddressComparator());
                    display(user);
                }
                if (opt == 5) {
                    break;
                }
            }
        }
    }

    void deleteUser(ArrayList<User> user, Set<Integer> rollset) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No. of user to deleted : ");
        int delroll = sc.nextInt();
        if (rollset.contains(delroll)) {
            for (var u : user) {
                if (u.getRollno() == delroll) {
                    user.remove(u);
                    break;
                }
            }
            System.out.println("User deleted successfully!!");
        } else {
            System.out.println("User doesn't exists");
        }
    }

    void saveDetails(ArrayList<User> user) throws IOException {
        //Serializing the data
        try {
            FileOutputStream fileout = new FileOutputStream("out.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            for (var u : user) {
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
        ArrayList<User> fileread = new ArrayList<>();
        try {
            FileInputStream filein = new FileInputStream("out.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            for (int i = 0; i < user.size(); i++) {
                User u = (User) in.readObject();
                fileread.add(u);
            }
            in.close();
            filein.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
            System.out.println("---------------------------------------------------------------");
            for (var u : fileread) {
                System.out.println(u.toString());
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> rollset = new HashSet<>();
        ArrayList<User> user = new ArrayList<>();
        Part part = new Part();
        while (true) {
            System.out.println("1.Add user details\n2.Display user details\n3.Delete user details\n4.Save user details\n5.Exit\n");
            System.out.print("Choose an option : ");
            int option = sc.nextInt();
            if (option == 1) {
                User input = part.takeInput(rollset);
                if (input != null) {
                    user.add(input);
                }
            }
            if (option == 2) {
                part.displayUser(user);
            }
            if (option == 3) {
                part.deleteUser(user, rollset);
            }
            if (option == 4) {
                try {
                    part.saveDetails(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (option == 5) {
                return;
            }
        }
    }
}
