package org.example.assignment2;

import java.util.Comparator;

public class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if(o1.age == o2.age){
            return 0;
        }
        else if(o1.age > o2.age){
            return 1;
        }
        return -1;
    }

}