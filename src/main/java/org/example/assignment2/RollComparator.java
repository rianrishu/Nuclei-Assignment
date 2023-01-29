package org.example.assignment2;


import java.util.Comparator;

public class RollComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getRollno() == o2.getRollno()) {
            return 0;
        } else if (o1.getRollno() > o2.getRollno()) {
            return 1;
        }
        return -1;
    }

}
