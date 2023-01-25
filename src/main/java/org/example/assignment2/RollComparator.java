package org.example.assignment2;


import java.util.Comparator;

public class RollComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if(o1.rollno == o2.rollno){
            return 0;
        }
        else if(o1.rollno > o2.rollno){
            return 1;
        }
        return -1;
    }

}
