package org.example.assignment2;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class UserManagement {

    private static UserManagement instance = new UserManagement();

    private UserManagement() {

    }

    public static UserManagement getInstance() {
        return instance;
    }


    protected User takeInput(ArrayList<User> users, Set<Integer> rollset){
        Scanner sc = new Scanner(System.in);
        return takeInput(users, rollset, sc);
    }

    protected User takeInput(ArrayList<User> users, Set<Integer> rollset, Scanner sc) {
        String name;
        String address;
        int rollno;
        int age;

        ArrayList<COURSES> courses = new ArrayList<>();

        System.out.print("Enter name : ");
        name = sc.nextLine();

        while (true) {
            try {
                System.out.print("Enter age : ");
                age = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter age in round off number.(ex: 22, 23)");
                sc.nextLine();
            }
        }

        sc.nextLine();
        System.out.print("Enter address : ");
        address = sc.nextLine();

        while (true) {
            try {
                System.out.print("Enter rollno : ");
                rollno = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter roll number in number.(ex: 1, 2)");
                sc.nextLine();
            }
        }


        System.out.print("Enter number of courses : ");
        int noOfCourses = sc.nextInt();
        if (noOfCourses < 4 || noOfCourses > 6) {
            System.out.println("Number of courses must be between 4 and 6");
            System.out.print("Enter number of courses : ");
            noOfCourses = sc.nextInt();
        }

        System.out.println("Choose " + noOfCourses + " courses from ");
        while (courses.size() < noOfCourses) {
            System.out.println("Available Courses : ");
            System.out.println("1.A\n2.B\n3.C\n4.D\n5.E\n6.F");
            int opt;
            while (true) {
                try {
                    System.out.print("Enter option ex:-(1, 2, 3, 4, 5, or 6): ");
                    opt = sc.nextInt();
                    if (opt == 1) {
                        if (!courses.contains(COURSES.A)) {
                            courses.add(COURSES.A);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else if (opt == 2) {
                        if (!courses.contains(COURSES.B)) {
                            courses.add(COURSES.B);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else if (opt == 3) {
                        if (!courses.contains(COURSES.C)) {
                            courses.add(COURSES.C);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else if (opt == 4) {
                        if (!courses.contains(COURSES.D)) {
                            courses.add(COURSES.D);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else if (opt == 5) {
                        if (!courses.contains(COURSES.E)) {
                            courses.add(COURSES.E);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else if (opt == 6) {
                        if (!courses.contains(COURSES.F)) {
                            courses.add(COURSES.F);
                        } else {
                            System.out.println("This course already is list, Please choose another one");
                        }
                        break;
                    } else {
                        System.out.println("Please choose option as 1, 2, 3, 4, 5, or 6");
                        sc.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter option number in number");
                    sc.nextLine();
                }
            }
        }
        System.out.println("courses added");

        User result = null;
        if (!rollset.contains(rollno)) {
            result = new User(name, age, address, rollno, courses);
            rollset.add(rollno);
            System.out.println("User added successfully\n");
        } else {
            System.out.println("User roll number already in list\n");
            boolean isNameInList = false;
            boolean isAddressInList = false;
            for (var user : users) {
                if (user.getName() == name) {
                    isNameInList = true;
                } else if (user.getAddress() == address) {
                    isAddressInList = true;
                }
            }
            if (!isNameInList) {
                System.out.println("User name is not there in list\n");
            } else if (!isAddressInList) {
                System.out.println("User address is not there in list\n");
            } else {
                System.out.println("User already exists\n");
            }
        }
        return result;
    }

    void display(ArrayList<User> users) {
        System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
        System.out.println("---------------------------------------------------------------");
        for (var user : users) {
            System.out.println(user.toString());
        }
    }

    void displayUser(ArrayList<User> users) {
        if (users.size() == 0){
            System.out.println("User list is empty, nothing to display");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------User Details------------------------");
        display(users);
        System.out.print("Would you like to sort the result(y/n) : ");
        char option = sc.next().charAt(0);
        if (option == 'y' || option == 'Y') {
            while (true) {
                while (true) {
                    try {
                        System.out.println("Sort according to : ");
                        System.out.println("1.Name\n2.Roll No.\n3.Age\n4.Address\n5.Exit sorting");
                        System.out.print("Enter option : ");
                        int opt = sc.nextInt();
                        if (opt == 1) {
                            users.sort(new NameComparator());
                            display(users);
                        } else if (opt == 2) {
                            users.sort(new RollComparator());
                            display(users);
                        } else if (opt == 3) {
                            users.sort(new AgeComparator());
                            display(users);
                        } else if (opt == 4) {
                            users.sort(new AddressComparator());
                            display(users);
                        } else if (opt == 5) {
                            return;
                        } else {
                            System.out.println("Please choose option as 1, 2, 3, 4, or 5");
                            sc.nextLine();
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter option number in number.");
                        sc.nextLine();
                    }
                }
            }
        }
    }

    void deleteUser(ArrayList<User> users, Set<Integer> rollset) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No. of user to deleted : ");
        int delroll = sc.nextInt();
        if (rollset.contains(delroll)) {
            for (var user : users) {
                if (user.getRollno() == delroll) {
                    System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(user.toString());
                    users.remove(user);
                    rollset.remove(delroll);
                    break;
                }
            }
            System.out.println("User deleted successfully!!");
        } else {
            System.out.println("User doesn't exists");
        }
    }

    void saveDetails(ArrayList<User> users) throws IOException {
        //Serializing the data
        try (FileOutputStream fileout = new FileOutputStream("out.txt");
             PrintWriter out = new PrintWriter(fileout)) {

            for (var user : users) {
                out.println(user.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error File not found");
            System.out.println("Error Message : " + e.getMessage());
        }

        System.out.println("\nUser details saved to file out.txt\n");

        System.out.println("\nReading the data from file\n");

        //Deserializing the data
        try (FileInputStream filein = new FileInputStream("out.txt");
             Scanner in = new Scanner(filein)) {

            System.out.println("Name\t\tRoll No.\tAge\tAddress\t\tCourses");
            System.out.println("---------------------------------------------------------------");
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error File not found");
            System.out.println("Error Message : " + e.getMessage());
        }

        System.out.println("Using JSON parser");

        try (FileOutputStream fileout = new FileOutputStream("out.json");
             PrintWriter out = new PrintWriter(fileout)) {

            out.println(new Gson().toJson(users));


        } catch (FileNotFoundException e) {
            System.out.println("Error File not found");
            System.out.println("Error Message : " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> rollset = new HashSet<>();
        ArrayList<User> users = new ArrayList<>();
        UserManagement userManagement = UserManagement.getInstance();
        while (true) {
            System.out.println("1.Add user details\n2.Display user details\n3.Delete user details\n4.Save user details\n5.Exit\n");
            System.out.print("Choose an option : ");
            int option = sc.nextInt();
            if (option == 1) {
                User input = userManagement.takeInput(users, rollset);
                if (input != null) {
                    users.add(input);
                }
            } else if (option == 2) {
                userManagement.displayUser(users);
            } else if (option == 3) {
                userManagement.deleteUser(users, rollset);
            } else if (option == 4) {
                try {
                    userManagement.saveDetails(users);
                } catch (IOException e) {
                    System.out.println("Error in save user details");
                    System.out.println("Error Message : " + e.getMessage());
                }
            } else if (option == 5) {
                return;
            } else {
                System.out.println("Please choose option as 1, 2, 3, 4, or 5");
                sc.nextLine();
            }
        }
    }
}
